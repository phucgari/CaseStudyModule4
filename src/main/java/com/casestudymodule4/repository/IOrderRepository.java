package com.casestudymodule4.repository;

import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
    Iterable<Order> findAllByOrderer(User user);
}
