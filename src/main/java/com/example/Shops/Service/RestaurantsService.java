package com.example.Shops.Service;

import com.example.Shops.DTOs.RestaurantsDTO;
import com.example.Shops.Models.Restaurants;
import com.example.Shops.Repository.MenusRepository;
import com.example.Shops.Repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RestaurantsService {

    @Autowired
    public RestaurantsRepository restaurantsRepository;
    @Autowired
    public MenusRepository menusRepository;

    public void addRestaurant(RestaurantsDTO restaurantDTO) {
        Restaurants restaurants = new Restaurants();
        restaurants.setName(restaurantDTO.getName());
        restaurants.setDescription(restaurantDTO.getDescription());
        restaurants.setLocation(restaurantDTO.getLocation());
        restaurants.setCreatedDate(new Date());


        restaurantsRepository.save(restaurants);

        // Convert back to DTO
        RestaurantsDTO createdRestaurantDTO = new RestaurantsDTO();
        createdRestaurantDTO.setRestaurantId(restaurants.getRestaurantId());
        createdRestaurantDTO.setName(restaurants.getName());
        createdRestaurantDTO.setDescription(restaurants.getDescription());
        createdRestaurantDTO.setLocation(restaurants.getLocation());
        createdRestaurantDTO.setCreatedDate(restaurants.getCreatedDate());
    }

    public String deleteRestaurant(Long id) {
        Optional<Restaurants> restaurant = restaurantsRepository.findById(id);
        restaurantsRepository.deleteById(id);
        return restaurant.get().getName();

    }

    public String updateRestaurant(Long id, Restaurants restaurants) {
        Optional<Restaurants> oldRestaurant = Optional.ofNullable(restaurantsRepository.findById
                (id).orElseThrow(() -> new NoSuchElementException("Restaurant not found with ID: " + restaurants.getRestaurantId())));
        ;

        if (restaurants.getName() != null) {
            oldRestaurant.get().setName(restaurants.getName());
        }
        if (restaurants.getDescription() != null) {
            oldRestaurant.get().setDescription(restaurants.getDescription());
        }
        if (restaurants.getLocation() != null) {
            oldRestaurant.get().setLocation(restaurants.getLocation());
        }
        oldRestaurant.get().setCreatedDate(new Date());

        restaurantsRepository.save(oldRestaurant.get());
        return oldRestaurant.get().getName();
    }

    public List<Restaurants> findAllRestaurants() {
        return restaurantsRepository.findAll();
    }
    public Restaurants findRestaurantById(Long id) {
        return restaurantsRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("Restaurant not found with ID: " + id));
    }
}
