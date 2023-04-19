package com.casestudymodule4.model.user;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.picture.Picture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Picture avatar;

    @NotBlank
    @Size(min = 6, max = 50)
    private String fullName;

    @NotBlank
    @Size(min = 6, max = 32)
    private String username;

    @JsonIgnore
    @NotBlank
    @Size(min = 6, max = 8)
    private String password;

    @Size(max = 50)
    private String email;

    @Size(min = 10, max = 15)
    private String phone;

    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    Set<Home> home;

    public Set<Home> getHome() {
        return home;
    }

    public void setHome(Set<Home> home) {
        this.home = home;
    }

    public User() {
    }

    public User(Long id, Picture avatar, String fullName, String username, String password, String email, String phone, String address, Set<Role> roles) {
        this.id = id;
        this.avatar = avatar;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.roles = roles;
    }

    public User(Picture avatar,
                @NotBlank
                @Size(min = 6, max = 50) String fullName,
                @NotBlank
                @Size(min = 6, max = 32) String username,
                @NotBlank
                @Size(min = 6, max = 8) String password,
                @Size(max = 50) String email,
                @Size(min = 10, max = 15) String phone,
                String address
    ) {
        this.avatar = avatar;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Picture getAvatar() {
        if (avatar == null) {
            return new Picture();
        }
        return avatar;
    }

    public void setAvatar(Picture avatar) {
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

