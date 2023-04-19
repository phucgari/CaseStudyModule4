package com.casestudymodule4.controller.order;

import com.casestudymodule4.model.DTO.MonthMoneyTable;
import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.model.user.User;
import com.casestudymodule4.security.jwt.JwtProvider;
import com.casestudymodule4.service.order.IOrderService;
import com.casestudymodule4.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {
    @Autowired
    IOrderService service;
    @Autowired
    JwtProvider jwtProvider;
    @GetMapping("all")
    public ResponseEntity<Iterable<Order>> getAllOrder(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Optional<Order> optionalOrder = service.findById(id);
        return optionalOrder.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        if(order.getId()!=null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return ResponseEntity.ok(service.save(order));
    }
    @PutMapping("update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        if(order.getId()==null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return ResponseEntity.ok(service.save(order));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id){
        Optional<Order> optionalOrder=service.findById(id);
        if (optionalOrder.isEmpty())return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(service.removeOrderBefore1Day(optionalOrder.get()))return ResponseEntity.ok(optionalOrder.get());
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("user/{user}")
    public ResponseEntity<Iterable<Order>> findByOrderer(@PathVariable User user){
        return ResponseEntity.ok(service.findAllByOrderer(user));
    }
    @GetMapping("owner")
    public ResponseEntity<Iterable<MonthMoneyTable>> printMonthMoneyTableByOwner(@RequestHeader(name = "Authorization") String authHeader){
        User user=jwtProvider.getUserFromBearer(authHeader).get();
        return ResponseEntity.ok(service.printMonthMoneyTableByOwner(user));
    }
    @PostMapping("checkin/{order}")
    public ResponseEntity<Order>checkIn(@PathVariable Order order){
        if(order.isCheckedIn())return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        order.setCheckedIn(true);
        return ResponseEntity.ok(service.save(order));
    }
}
