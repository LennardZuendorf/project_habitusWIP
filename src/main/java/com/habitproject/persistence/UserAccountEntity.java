package com.habitproject.persistence;

import javax.persistence.*;

/**
 * UserAccountEntity defines database entries for persistence of goals
 * This is only for testing purposes, finale user login will be done with SpringSecurity
 */

@Entity
@Table(name = "account")
public class UserAccountEntity {

    //variables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    @Column
    private String username;

    @Column
    private String email;

    //constructor
    public UserAccountEntity(String username, String email){
        this.username = username;
        this.email = email;
    }
    protected UserAccountEntity() {

    }

    //getter and setter
    public Long getUid() {
        return uid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
