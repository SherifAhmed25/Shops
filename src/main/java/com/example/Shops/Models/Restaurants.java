package com.example.Shops.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> orders; // One restaurant can have many orders

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Menus> menus;


    private String name;
    private String description;
    private String location;
    private Date createdDate;
}
