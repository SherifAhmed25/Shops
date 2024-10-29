package com.example.Shops.Controllers;

import com.example.Shops.Models.Menus;
import com.example.Shops.Models.Restaurants;
import com.example.Shops.Service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AdminsController {

    @Autowired
    public  AdminsService adminsService;

    @PostMapping ("/addRestaurant")
    public String addRestaurant(@RequestBody Restaurants restaurants) {
        adminsService.addRestaurant(restaurants);
        return restaurants.getName() + "  Restaurant added successfully";
    }

    @PostMapping("/deleteRestaurant/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
       String name = adminsService.deleteRestaurant(id);
       return name + "  Restaurant deleted successfully";
    }

    @PutMapping("/updateRestaurant/{id}")
    public String updateRestaurant(@PathVariable Long id,@RequestBody Restaurants restaurants) {
        String name = adminsService.updateRestaurant(id,restaurants);
        return name + "  Restaurant updated successfully";
    }
    @GetMapping("/findAllRestaurants")
    public List<Restaurants> findAllRestaurants() {
        return adminsService.findAllRestaurants();
    }

//    @PostMapping("/addMenu")
//    public String addMenu(@RequestBody Menus menus) {
//        adminsService.addMenu(menus);
//        return menus.getMenuID() + "  Menu added successfully";
//    }

//    @PostMapping("/addMenu")
//    public String createMenu(@RequestBody Menus menu) {
//        if (menu.getName() == null) {
//            return "Menu name cannot be null";
//        }
//        adminsService.addMenu(menu);
//        return menu.getName() + "  Restaurant added successfully";
//    }


    @PostMapping("/deleteMenu/{id}")
    public String deleteMenu(@PathVariable Long id) {
        String name = adminsService.deleteMenu(id);
        return name + "  Menu deleted successfully";
    }
    @GetMapping ("/findAllMenus")
    public List<Menus> findAllMenus() {
        return adminsService.findAllMenus();
    }

}
