package com.atl.academy.productms.controller;

import com.atl.academy.productms.model.dto.ProductDto;
import com.atl.academy.productms.model.request.ProductRequest;
import com.atl.academy.productms.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${product-url}")
@RequiredArgsConstructor
@Api(tags = "Product Controller")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ApiOperation(value = "Get All Products")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Product by Id")
    public ResponseEntity<ProductDto> getProductById(
            @PathVariable @ApiParam(name = "id", value = "Product id", example = "2") Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    @ApiOperation(value = "Add Product")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return new ResponseEntity<>("Product was added successfully!", HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/decrease-count")
    @ApiOperation(value = "Decrease Product Count")
    public void decreaseProductCount(
            @PathVariable @ApiParam(name = "id", value = "Product id", example = "2") Long id,
            @RequestParam @ApiParam(name = "count", value = "Product count", example = "5") Long count) {
        productService.decreaseProductCount(id, count);
    }
}
