package com.balakhontsev.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue
    private Long orderId;

    private String orderFullName;

    private String orderFullAddress;

    private String orderContactNumber;

    private String orderAlternateContactNumber;

    private String orderStatus;

    private Double orderAmount;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    public OrderDetail(String orderFullName,
                       String orderFullAddress,
                       String orderContactNumber,
                       String orderAlternateContactNumber,
                       String orderStatus,
                       Double orderAmount,
                       Product product,
                       User user) {
        this.orderFullName = orderFullName;
        this.orderFullAddress = orderFullAddress;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateContactNumber = orderAlternateContactNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
    }
}
