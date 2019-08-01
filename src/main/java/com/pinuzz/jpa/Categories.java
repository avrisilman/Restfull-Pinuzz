package com.pinuzz.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="categories")
public class Categories {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="categories_id")
    public long id;

    @Column(name="name")
    public String name;

    @Column(name="url_images")
    public String urlImages;

    @OneToMany(mappedBy="categories")
    public Set<Products> products;

}
