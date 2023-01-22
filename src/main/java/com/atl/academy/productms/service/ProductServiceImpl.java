package com.atl.academy.productms.service;

import com.atl.academy.productms.exception.ProductAlreadyExistsException;
import com.atl.academy.productms.exception.ProductNotFoundException;
import com.atl.academy.productms.exception.ProductNotLeftException;
import com.atl.academy.productms.model.dto.ProductDto;
import com.atl.academy.productms.model.request.ProductRequest;
import com.atl.academy.productms.entity.Product;
import com.atl.academy.productms.mapper.ProductMapper;
import com.atl.academy.productms.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.atl.academy.productms.model.constants.ExceptionConstants.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public List<ProductDto> getAllProduct() {
        log.info("ProductServiceImpl.getAllProduct.start");
        var products = productRepository
                .findAll()
                .stream()
                .map(productMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("ProductServiceImpl.getAllProduct.end");
        return products;
    }

    @Override
    public ProductDto getProductById(Long id) {
        log.info("ProductServiceImpl.getProductById.start with id: {}", id);
        var product = productMapper.mapEntityToDto(fetchProductIfExists(id));
        log.info("ProductServiceImpl.getProductById.end with id: {}", id);
        return product;
    }

    @Override
    public void createProduct(ProductRequest productRequest) {
        log.info("ProductServiceImpl.createProduct.start");
        if (isProductExists(productRequest)) {
            log.error("ProductServiceImpl.createProduct.error");
            throw new ProductAlreadyExistsException(PRODUCT_ALREADY_EXISTS_CODE,
                    String.format(PRODUCT_ALREADY_EXISTS_MESSAGE, productRequest.getName()));
        }
        Product product = productMapper.mapRequestToEntity(productRequest);
        productRepository.save(product);
        log.info("ProductServiceImpl.createProduct.end");
    }

    @Override
    public void decreaseProductCount(Long id, Long count) {
        log.info("ProductServiceImpl.decreaseProductCount.start with id: {} and count: {}", id, count);
        var product = fetchProductIfExists(id);
        if (count <= product.getCount()) {
            product.setCount(product.getCount() - count);
            productRepository.save(product);
            log.info("ProductServiceImpl.decreaseProductCount.end with id: {} and count: {}", id, count);
        } else {
            log.error("ProductServiceImpl.decreaseProductCount.error with id: {} and count: {}", id, count);
            throw new ProductNotLeftException(PRODUCT_NOT_LEFT_CODE,
                    String.format(PRODUCT_NOT_LEFT_CODE_MESSAGE, count, id));
        }
    }

    private Product fetchProductIfExists(Long id) {
        return productRepository.findById(id).orElseThrow(() -> {
            log.error("ProductServiceImpl.fetchProductIfExists.error with id: {}", id);
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND_CODE, String.format(PRODUCT_NOT_FOUND_MESSAGE, id));
        });
    }

    private boolean isProductExists(ProductRequest productRequest) {
        return productRepository
                .findAll()
                .stream()
                .anyMatch(tutorial -> Objects.equals(tutorial.getName(), productRequest.getName()));
    }
}
