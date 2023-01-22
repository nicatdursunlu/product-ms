package com.atl.academy.productms.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Product Request", description = "Model which represents a product entity")
public class ProductRequest {

    @NotBlank(message = "Name can not be empty")
    @ApiModelProperty(value = "Product's name", required = true)
    private String name;

    @PositiveOrZero(message = "Count must be positive or zero")
    @NotNull(message = "Count can not be null")
    @ApiModelProperty(value = "Product's count", required = true)
    private Long count;

    @NotNull(message = "Price can not be null")
    @PositiveOrZero(message = "Price must be positive or zero")
    @ApiModelProperty(value = "Product's price", required = true)
    private BigDecimal price;
}
