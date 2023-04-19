package com.casestudymodule4.model.home.order;

import com.casestudymodule4.model.home.Home;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "homeDays", uniqueConstraints = {@UniqueConstraint(columnNames = {"status_id", "day"})})
public class HomeDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "status_id")
    private Status status;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate day;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "home_id")
    @JsonBackReference
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
