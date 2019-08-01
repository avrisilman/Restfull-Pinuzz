package com.pinuzz.jpa;

import javax.persistence.*;

@Entity
@Table(name="delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="delivery_id")
    private long id;

    @ManyToOne
    @JoinColumn(name="users_id")
    private Users users;

    @Column(name="surename")
    private String surename;

    @Column(name="address1")
    private String address1;

    @Column(name="address2")
    private String address2;

    @Column(name="address3")
    private String address3;

    @Column(name="postcode")
    private String postcode;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

}
