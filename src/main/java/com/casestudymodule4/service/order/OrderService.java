package com.casestudymodule4.service.order;

import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOderService{
    @Autowired
    IOrderRepository repository;
    @Override
    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
