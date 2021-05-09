package com.habitproject.persistence;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {

    //variables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String account_name;

    @Column
    private String email;

    //constructor
    public AccountEntity(String account_name, String email){
        this.account_name = account_name;
        this.email = email;
    }
    protected AccountEntity() {

    }

    //getter and setter
    public Long getId() {
        return id;
    }
    public String getAccount_name() {
        return account_name;
    }
    public void setAccount_name(String username) {
        this.account_name = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
