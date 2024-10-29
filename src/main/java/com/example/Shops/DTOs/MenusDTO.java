package com.example.Shops.DTOs;

import java.util.Date;

public class MenusDTO {
    private Long menuID;
    private String name;
    private String description;
    private String price;
    private Date createdDate;
    private Long restaurantId; // Reference to restaurant ID

    // Getters and Setters
    public Long getMenuID() {
        return menuID;
    }
    public void setMenuID(Long menuID) {
        this.menuID = menuID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}

