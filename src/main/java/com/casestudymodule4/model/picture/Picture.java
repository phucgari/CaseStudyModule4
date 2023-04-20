package com.casestudymodule4.model.picture;

import com.casestudymodule4.model.home.Home;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String src;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_id")
    @JsonBackReference
    private Home home;

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

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

