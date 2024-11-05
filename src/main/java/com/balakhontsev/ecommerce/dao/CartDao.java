package com.balakhontsev.ecommerce.dao;

import com.balakhontsev.ecommerce.entity.Cart;
import com.balakhontsev.ecommerce.entity.Product;
import com.balakhontsev.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
    boolean existsByProductAndUser(Product product, User user);

    List<Cart> findByUser(User user);
}
