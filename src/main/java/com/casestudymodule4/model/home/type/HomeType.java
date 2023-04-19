package com.casestudymodule4.model.home.type;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "homeTypes")
public class HomeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @NaturalId
    private TypeName name;

    public enum TypeName {
        SINGLEROOM, DOUBLEROOM, PRESIDENTROOM, VIPROOM, LUXURYROOM
    }

    public HomeType() {
    }

    public HomeType(Long id, TypeName name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeName getName() {
        return name;
    }

    public void setName(TypeName name) {
        this.name = name;
    }
}
