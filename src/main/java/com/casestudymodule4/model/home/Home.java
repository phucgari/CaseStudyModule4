package com.casestudymodule4.model.home;

import com.casestudymodule4.model.Picture;
import com.casestudymodule4.model.home.type.HomeType;
import com.casestudymodule4.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "homes")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name ;
   @ManyToMany
   private Set<HomeType> types;

   private String address;
   private int numberOfBathroom;
   private int numnerOfBedroom;
   private String description;
   private Double price;
   @ManyToOne
   private Set<Picture> pictures;
   @ManyToOne
   private User owner;


}
