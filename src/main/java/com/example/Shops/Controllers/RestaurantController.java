package com.example.Shops.Controllers;

import com.example.Shops.DTOs.RestaurantsDTO;
import com.example.Shops.Models.Restaurants;
import com.example.Shops.Repository.RestaurantsRepository;
import com.example.Shops.Service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api/auth")
public class RestaurantController {

    @Autowired
    RestaurantsService restaurantsService;
    @Autowired
    public RestaurantsRepository restaurantsRepository;

    @PostMapping("/addRestaurant")
    public String addRestaurant(@RequestBody RestaurantsDTO restaurantDTO) {

        restaurantsService.addRestaurant(restaurantDTO);
        return restaurantDTO.getName() + "  Restaurant added successfully";
    }

    @PostMapping("/deleteRestaurant/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
        String name = restaurantsService.deleteRestaurant(id);
        return name + "  Restaurant deleted successfully";
    }

    @PutMapping("/updateRestaurant/{id}")
    public String updateRestaurant(@PathVariable Long id,@RequestBody Restaurants restaurants) {
        String name = restaurantsService.updateRestaurant(id,restaurants);
        return name + "  Restaurant updated successfully";
    }
    @GetMapping("/findAllRestaurants")
    public List<Restaurants> findAllRestaurants() {
        return restaurantsService.findAllRestaurants();
    }

    @GetMapping("/findRestaurantById/{id}")
    public Restaurants findRestaurantById(@PathVariable Long id) {
        return restaurantsService.findRestaurantById(id);
    }
}
