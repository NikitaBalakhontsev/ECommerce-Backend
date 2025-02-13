package com.balakhontsev.ecommerce.service;

import com.balakhontsev.ecommerce.configuration.JwtRequestFilter;
import com.balakhontsev.ecommerce.dao.CartDao;
import com.balakhontsev.ecommerce.dao.ProductDao;
import com.balakhontsev.ecommerce.dao.UserDao;
import com.balakhontsev.ecommerce.entity.Cart;
import com.balakhontsev.ecommerce.entity.Product;
import com.balakhontsev.ecommerce.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductDao productDAO;
    private final UserDao userDao;
    private final CartDao cartDao;

    public ProductService(ProductDao productDAO,
                          UserDao userDao, CartDao cartDao) {
        this.productDAO = productDAO;
        this.userDao = userDao;
        this.cartDao = cartDao;
    }

    public Product addNewProduct(Product product) {
        return productDAO.save(product);
    }

    public List<Product> getAllProducts(int pageNumber, String searchKey) {

        if (pageNumber != -1){
            Pageable pageable = PageRequest.of(pageNumber, 8);

            if (searchKey.equals("")) {
                return productDAO.findAll(pageable).getContent();
            }
            else {
                return productDAO.findByProductNameContainsIgnoreCaseOrProductDescriptionContainsIgnoreCase(searchKey, searchKey, pageable);
            }
        }
        else {
            return productDAO.findAll();
        }
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public void deleteProductDetails(Long productId) {
        productDAO.deleteById(productId);
    }

    public Product getProductDetailsById(Long productId) {
        return productDAO.findById(productId).get();
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout,
                      Long productId) {
        if(isSingleProductCheckout && productId != -1) {


            List<Product> productList = new ArrayList<>();

            Product product = productDAO.findById(productId).get();
            productList.add(product);

            return productList;
        }
        else {
            User user = userDao.findById(JwtRequestFilter.CURRENT_USER).get();

            List<Cart> carts = cartDao.findByUser(user);

            return carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());

        }

    }
}
