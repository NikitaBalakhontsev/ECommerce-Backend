package com.balakhontsev.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductQuantity {

    private Long productId;
    private Long quantity;
}
