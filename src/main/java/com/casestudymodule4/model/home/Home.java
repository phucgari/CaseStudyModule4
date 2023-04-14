package com.casestudymodule4.model.home;

import com.casestudymodule4.model.picture.Picture;
import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.model.home.rating.Comment;
import com.casestudymodule4.model.home.rating.Rating;
import com.casestudymodule4.model.home.type.HomeType;
import com.casestudymodule4.model.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "homes")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private Set<HomeType> types;

    private String address;
    private int numberOfBathroom;
    private int numberOfBedroom;
    private String description;
    private Double price;
    @OneToMany
    @JoinColumn(name = "picture_id")
    private Set<Picture> pictures;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orderList;
    @OneToMany
    @JoinColumn(name="ratings_id")
    private Set<Rating> ratings;
    @OneToMany
    @JoinColumn(name = "comments_id")
    private Set<Comment> comments;

    public Home() {
    }

    public Home(Long id, String name,
                Set<HomeType> types,
                String address,
                int numberOfBathroom,
                int numberOfBedroom, String description,
                Double price,
                Set<Picture> pictures,
                User owner,
                List<Order> orderList,
                Set<Rating> ratings,
                Set<Comment> comments) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.address = address;
        this.numberOfBathroom = numberOfBathroom;
        this.numberOfBedroom = numberOfBedroom;
        this.description = description;
        this.price = price;
        this.pictures = pictures;
        this.owner = owner;
        this.orderList = orderList;
        this.ratings = ratings;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<HomeType> getTypes() {
        return types;
    }

    public void setTypes(Set<HomeType> types) {
        this.types = types;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfBathroom() {
        return numberOfBathroom;
    }

    public void setNumberOfBathroom(int numberOfBathroom) {
        this.numberOfBathroom = numberOfBathroom;
    }

    public int getNumberOfBedroom() {
        return numberOfBedroom;
    }

    public void setNumberOfBedroom(int numberOfBedroom) {
        this.numberOfBedroom = numberOfBedroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
