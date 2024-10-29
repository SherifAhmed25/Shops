package com.example.Shops.Service;

import com.example.Shops.DTOs.MenusDTO;
import com.example.Shops.Models.Menus;
import com.example.Shops.Repository.MenusRepository;
import com.example.Shops.Repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MenusService {
    @Autowired
    public RestaurantsRepository restaurantsRepository;
    @Autowired
    public MenusRepository menusRepository;

    public void addMenu(MenusDTO menusDTO) {
        Menus menu = new Menus();
        menu.setCreatedDate(new Date());
        menu.setName(menusDTO.getName());
        menu.setDescription(menusDTO.getDescription());
        menu.setPrice(menusDTO.getPrice());
        menu.setRestaurant(restaurantsRepository.findById(menusDTO.getRestaurantId()).orElseThrow(() -> new NoSuchElementException("Restaurant not found with ID: " + menusDTO.getRestaurantId())));

         menusRepository.save(menu);

        // Convert back to DTO
        MenusDTO createdMenuDTO = new MenusDTO();
        createdMenuDTO.setMenuID(menu.getMenuID());
        createdMenuDTO.setName(menu.getName());
        createdMenuDTO.setDescription(menu.getDescription());
        createdMenuDTO.setPrice(menu.getPrice());
        createdMenuDTO.setCreatedDate(menu.getCreatedDate());
        createdMenuDTO.setRestaurantId(menu.getRestaurant().getRestaurantId());

    }


    public String deleteMenuByID(Long id) {
       Menus menu = menusRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Menu not found with ID: " + id));
        String name = menu.getName();
        menusRepository.deleteById(id);
        return name;
    }
    public Menus findMenuByID (long id) {
       Menus menu = menusRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Menu not found with ID: " + id));
        return menu;
    }

    public List<Menus> findAllMenus() {
        return menusRepository.findAll();
    }
}
