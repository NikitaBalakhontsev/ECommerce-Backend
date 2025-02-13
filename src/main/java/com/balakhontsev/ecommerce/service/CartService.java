package com.balakhontsev.ecommerce.service;

import com.balakhontsev.ecommerce.configuration.JwtRequestFilter;
import com.balakhontsev.ecommerce.dao.CartDao;
import com.balakhontsev.ecommerce.dao.ProductDao;
import com.balakhontsev.ecommerce.dao.UserDao;
import com.balakhontsev.ecommerce.entity.Cart;
import com.balakhontsev.ecommerce.entity.Product;
import com.balakhontsev.ecommerce.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartDao cartDao;

    private final ProductDao productDao;
    private final UserDao userDao;

    public CartService(CartDao cartDao, ProductDao productDao, UserDao userDao) {
        this.cartDao = cartDao;
        this.productDao = productDao;
        this.userDao = userDao;
    }

    public Cart addToCart(Long productId) {
        Product product = productDao.findById(productId).get();
        String userName = JwtRequestFilter.CURRENT_USER;

        User user = null;
        if (userName != null) {
            user = userDao.findById(userName).get();
        }

        if (product != null && user != null) {

            if (!cartDao.existsByProductAndUser(product, user)) {
                Cart cart = new Cart(product, user);
                return cartDao.save(cart);
            }
        }
        return null;
    }

    public List<Cart> getCartDetails() {
        User user = userDao.findById(JwtRequestFilter.CURRENT_USER).get();

        return cartDao.findByUser(user);
    }

    public void deleteCartItem(Long cartId) {
        cartDao.deleteById(cartId);
    }
}
