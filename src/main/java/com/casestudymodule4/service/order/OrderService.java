package com.casestudymodule4.service.order;

import com.casestudymodule4.model.DTO.MonthMoneyTable;
import com.casestudymodule4.model.home.order.HomeDay;
import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.model.user.User;
import com.casestudymodule4.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    @Override
    public Iterable<Order> findAllByOrderer(User user){
        return repository.findAllByOrderer(user);
    }

    @Override
    public Iterable<MonthMoneyTable> printMonthMoneyTableByOwner(User user) {
        return repository.printMonthMoneyTableByOwner(user.getId());
    }

    @Override
    public boolean removeOrderBefore1Day(Order order) {
//        for (HomeDay day :
//                order.getOrderDay()) {
//            if(day.getDay().isBefore(LocalDate.now().plusDays(1)))return false;
//        }
//        repository.delete(order);
        return true;
    }
}
