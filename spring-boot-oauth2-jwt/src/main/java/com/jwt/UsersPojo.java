package com.jwt;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class UsersPojo {
    private String username;
    private String password;

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

    public Collection<GrantedAuthority> getListOfgrantedAuthorities() {
        return listOfgrantedAuthorities;
    }

    public void setListOfgrantedAuthorities(Collection<GrantedAuthority> listOfgrantedAuthorities) {
        this.listOfgrantedAuthorities = listOfgrantedAuthorities;
    }

    private Collection<GrantedAuthority> listOfgrantedAuthorities = new ArrayList<>();
}
