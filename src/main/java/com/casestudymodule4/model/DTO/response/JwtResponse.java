package com.casestudymodule4.model.DTO.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String fullName;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse() {
    }

    public JwtResponse(String token, String type, String fullName, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.fullName = fullName;
        this.roles = roles;
    }

    public JwtResponse(String token, String fullName, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.fullName = fullName;
        this.roles = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
