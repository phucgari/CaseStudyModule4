package com.casestudymodule4.model.home.order;

import com.casestudymodule4.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime orderTime;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User orderer;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="order_id")
    private Set<HomeDay> homeDays;

    public Set<HomeDay> getHomeDays() {
        return homeDays;
    }

    public void setHomeDays(Set<HomeDay> homeDays) {
        this.homeDays = homeDays;
    }

    private boolean checkedIn;

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

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

    public User getOrderer() {
        return orderer;
    }

    public void setOrderer(User orderer) {
        this.orderer = orderer;
    }
}
