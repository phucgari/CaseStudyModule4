package com.casestudymodule4.model.home.order;

import com.casestudymodule4.model.home.Home;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "homeDays", uniqueConstraints = {@UniqueConstraint(columnNames = {"status_id", "day"})})
public class HomeDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @NotBlank
    private LocalDate day;
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;

    public HomeDay() {
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
