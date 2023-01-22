package com.atl.academy.productms.service;

import com.atl.academy.productms.model.dto.ProductDto;
import com.atl.academy.productms.model.request.ProductRequest;

import java.util.List;

public interface ProductService {
List<ProductDto> getAllProduct();
ProductDto getProductById(Long id);
void createProduct(ProductRequest productRequest);
void decreaseProductCount(Long id,Long count);
}
