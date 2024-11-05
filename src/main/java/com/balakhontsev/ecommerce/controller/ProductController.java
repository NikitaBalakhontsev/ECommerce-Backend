package com.balakhontsev.ecommerce.controller;
import com.balakhontsev.ecommerce.entity.Product;
import com.balakhontsev.ecommerce.service.ProductService;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/addNewProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Admin')")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }


    @GetMapping({"/getAllProducts"})
    //@PreAuthorize("hasRole('Admin')")
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "") String searchKey) {
        return productService.getAllProducts(pageNumber, searchKey);
    }

    @DeleteMapping({"/deleteProductDetails/{productId}"})
    @PreAuthorize("hasRole('Admin')")
    public void deleteProductDetails(@PathVariable("productId") Long productId) {
        productService.deleteProductDetails(productId);
    }

    @GetMapping({"/getProductDetailsById/{productId}"})
    public Product getProductDetailsById(@PathVariable("productId") Long productId) {
        return productService.getProductDetailsById(productId);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getProductDetails/{isSingleProductCheckout}/{productId}"})
    public List<Product> getProductDetails(@PathVariable("isSingleProductCheckout") boolean isSingleProductCheckout,
                                           @PathVariable("productId") Long productId) {
        return productService.getProductDetails(isSingleProductCheckout, productId);
    }
}
