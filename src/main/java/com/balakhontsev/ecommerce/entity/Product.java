package com.balakhontsev.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    private String productName;
    @Column(length = 2000)
    private String productDescription;
    private Double productDiscountedPrice;
    private Double productActualPrice;
    private String imageUrl;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "product_images",
//            joinColumns = {
//                @JoinColumn(name = "product_id")
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "image_id")
//            }
//    )
//    private Set<ImageModel> productImages;
}
