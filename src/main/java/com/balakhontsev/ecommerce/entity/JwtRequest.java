package com.balakhontsev.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {

    private String userName;

    private String userPassword;



}
