package com.atl.academy.productms.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Product Dto", description = "Model which represents a product entity")
public class ProductDto {
    @ApiModelProperty(value = "Product's id", required = true)
    private Long id;

    @ApiModelProperty(value = "Product's name", required = true)
    private String name;

    @ApiModelProperty(value = "Product's count", required = true)
    private Long count;

    @ApiModelProperty(value = "Product's price", required = true)
    private BigDecimal price;

    @ApiModelProperty(value = "Product's price", required = true)
    private BigDecimal price12;
}
