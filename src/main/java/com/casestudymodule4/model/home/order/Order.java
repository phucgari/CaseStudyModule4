package com.casestudymodule4.model.home.order;

import com.casestudymodule4.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private LocalDateTime orderTime;
    @OneToMany
    @JoinColumn(name="order_id")
    private Set<HomeDay> orderDay;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User orderer;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Set<HomeDay> getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Set<HomeDay> orderDay) {
        this.orderDay = orderDay;
    }

    public User getOrderer() {
        return orderer;
    }

    public void setOrderer(User orderer) {
        this.orderer = orderer;
    }
}
