package com.pinuzz.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="orders_id")
    private long id;

    @ManyToOne
    @JoinColumn(name="users_id", nullable=false)
    private Users users;

    @ManyToOne
    @JoinColumn(name="products_id", nullable=false)
    private Products products;

    @Column(name="payment_type")
    private String paymentType;

    @Column(name="datetimes")
    private Date datetimes;

    @Column(name="status")
    private int status;

    @Column(name="total")
    private double total;


}
