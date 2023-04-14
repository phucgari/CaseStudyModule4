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
    private Name name;

    private enum Name {
        VILLA, APARTMENT, MOTEL;
    }
}
