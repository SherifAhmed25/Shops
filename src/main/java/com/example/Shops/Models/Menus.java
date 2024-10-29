package com.example.Shops.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Menus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long menuID;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    @JsonManagedReference
    private Restaurants restaurant;

    private String Name;
    private String Description;
    private String Price;
    private Date CreatedDate;
}
