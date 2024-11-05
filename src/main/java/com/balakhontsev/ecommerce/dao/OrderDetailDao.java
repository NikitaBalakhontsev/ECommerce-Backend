package com.balakhontsev.ecommerce.dao;

import com.balakhontsev.ecommerce.entity.OrderDetail;
import com.balakhontsev.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderStatus(String orderStatus);
    List<OrderDetail> findByUser(User user);

    List<OrderDetail> findAllByOrderByUserUserName();
}
