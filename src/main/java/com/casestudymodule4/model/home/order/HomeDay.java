package com.casestudymodule4.model.home.order;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class HomeDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private Status status;
   private LocalDate day;

    public HomeDay() {
    }

    public HomeDay(Long id, Status status, LocalDate day) {
        this.id = id;
        this.status = status;
        this.day = day;
    }

    public Long getId(){
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
