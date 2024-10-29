package com.example.Shops.Controllers;

import com.example.Shops.Models.Menus;
import com.example.Shops.Repository.MenusRepository;
import com.example.Shops.Service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class MenusController {
    @Autowired
    MenusService menusService;

    @PostMapping("/createMenu")
    public void createMenu(@RequestBody Menus menus) {
        menusService.addMenu(menus);
    }
}
