package com.casestudymodule4.model;

import javax.persistence.*;


@Entity
@Table
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String src;

    public Picture() {
    }

    public Picture(Long id, String src) {
        this.id = id;
        this.src = src;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}

