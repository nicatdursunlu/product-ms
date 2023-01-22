package com.atl.academy.productms.mapper;

import com.atl.academy.productms.model.dto.ProductDto;
import com.atl.academy.productms.model.request.ProductRequest;
import com.atl.academy.productms.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ProductDto.class, ProductRequest.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "count", source = "count"),
            @Mapping(target = "price", source = "price")
    })
    Product mapDtoToEntity(ProductDto productDto);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "count", source = "count"),
            @Mapping(target = "price", source = "price")
    })
    ProductDto mapEntityToDto(Product product);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "count", source = "count"),
            @Mapping(target = "price", source = "price")
    })
    Product mapRequestToEntity(ProductRequest productRequest);

}
