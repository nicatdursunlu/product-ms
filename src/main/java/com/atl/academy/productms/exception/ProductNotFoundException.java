package com.atl.academy.productms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException {
    private String code;
    private String message;
}
