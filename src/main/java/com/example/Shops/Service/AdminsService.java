package com.example.Shops.Service;

import com.example.Shops.Models.Menus;
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
public class AdminsService {

    @Autowired
    public RestaurantsRepository restaurantsRepository;
    @Autowired
    public MenusRepository menusRepository;


    public void addRestaurant(Restaurants restaurants) {
        Restaurants restaurant = new Restaurants();
        restaurant.setName(restaurants.getName());
        restaurant.setDescription(restaurants.getDescription());
        restaurant.setLocation(restaurants.getLocation());
        restaurant.setCreatedDate(new Date());
        restaurantsRepository.save(restaurant);
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
///////////////////////// MENUS ////////////////////////////////////////////////

    //    public void addMenu(Menus newMenu) {
//        Menus oldMenu = new Menus();
//        oldMenu.setRestaurant(newMenu.getRestaurant());
//        oldMenu.setName(newMenu.getName());
//        oldMenu.setDescription(newMenu.getDescription());
//        oldMenu.setPrice(newMenu.getPrice());
//        oldMenu.setCreatedDate(new Date());
//        menusRepository.save(oldMenu);
//    }
//    public Menus addMenu(Menus menu) {
//        menu.setCreatedDate(new Date());
//        return menusRepository.save(menu);
//    }


    public String deleteMenu(Long id) {
        Optional<Menus> menu = menusRepository.findById(id);
        menusRepository.deleteById(id);
        return menu.get().getName();
    }

    public List<Menus> findAllMenus() {
       return menusRepository.findAll();
    }
}

