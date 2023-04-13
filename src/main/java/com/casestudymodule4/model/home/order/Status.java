package com.casestudymodule4.model.home.order;

import javax.persistence.*;

@Entity
@Table
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private enum name{
        Free, Orderd, Fixing
    }

    public Status() {
    }

    public Status(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
