package com.pinuzz.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="products_id")
    public long id;

    @ManyToOne
    @JoinColumn(name="categories_id", nullable=false)
    private Categories categories;

    @OneToMany(mappedBy="products")
    private Set<Orders> orders;

    @Column(name="name")
    public String name;

    @Column(name="url_images")
    public String urlImages;

    @Column(name="descriptions")
    public String descriptions;

}
