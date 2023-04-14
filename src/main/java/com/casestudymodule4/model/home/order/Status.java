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
    private StatusName name;
    private enum StatusName{
        Free, Ordered, Fixing
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
