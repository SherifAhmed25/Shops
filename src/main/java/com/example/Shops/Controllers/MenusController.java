package com.example.Shops.Controllers;

import com.example.Shops.DTOs.MenusDTO;
import com.example.Shops.Models.Menus;
import com.example.Shops.Repository.MenusRepository;
import com.example.Shops.Service.AdminsService;
import com.example.Shops.Service.MenusService;
import com.example.Shops.Service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class MenusController {
    @Autowired
    MenusService menusService;
    @Autowired
    AdminsService adminsService;
    @Autowired
    public MenusRepository menusRepository;
    @Autowired
    RestaurantsService restaurantsService;


    //    @PostMapping("/addMenu")
//    public String createMenu(@RequestBody Menus menu) {
//       Menus createdMenu = adminsService.addMenu(menu);
//        return createdMenu.getName() + "  Menu added successfully";
//
//    }
    @PostMapping("/addMenu")
    public String createMenu(@RequestBody MenusDTO menuDTO) {
      menusService.addMenu(menuDTO);
        return menuDTO.getName() + "Menu added successfully";
    }

    @PostMapping("/deleteMenu/{id}")
    public String deleteMenu(@PathVariable Long id) {
        String name = menusService.deleteMenuByID(id);
        return name + "  Menu deleted successfully";
    }

    @PostMapping("/findMenuById/{id}")
    public Menus findMenuByID(@PathVariable long id) {
        return menusService.findMenuByID(id);
    }
    @PostMapping("/findAllMenus")
    public List<Menus> findAllMenus() {
        return menusService.findAllMenus();
    }
}
