package com.pinuzz.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="users_id")
    private Long id;

    @Column(name="fullname")
    private String fullName;

    @Column(name="handphone")
    private String handphone;

    @Column(name="email")
    private String email;

    @Column(name="token")
    private String token;

    @OneToMany(mappedBy="users")
    private Set<Orders> orders;

    @OneToMany(mappedBy="users")
    private Set<Delivery> deliveries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
