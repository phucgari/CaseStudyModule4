package com.casestudymodule4.model.home.order;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name ="status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @NaturalId
    private StatusType name;
    public enum StatusType{
        Free, Ordered, Fixing
    }

    public Status() {
    }

    public Status(Long id, StatusType name) {
        this.id = id;
        this.name = name;
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

    public StatusType getName() {
        return name;
    }

    public void setName(StatusType name) {
        this.name = name;
    }
}
