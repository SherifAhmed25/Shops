package com.example.Shops.DTOs;

import java.util.Date;
import java.util.List;

public class RestaurantsDTO {
    private Long restaurantId;
    private String name;
    private String description;
    private String location;
    private Date createdDate;
    private List<MenusDTO> menus; // You can include menus or keep it simple

    // Getters and Setters
    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public List<MenusDTO> getMenus() {
        return menus;
    }
    public void setMenus(List<MenusDTO> menus) {
        this.menus = menus;
    }
}
