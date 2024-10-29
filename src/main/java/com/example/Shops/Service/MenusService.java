package com.example.Shops.Service;

import com.example.Shops.Models.Menus;
import com.example.Shops.Repository.MenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenusService {

    @Autowired
    MenusRepository menusRepository;

    public String addMenu(Menus menus) {
        menusRepository.save(menus);
        return menus.getMenuID() + "  Menu added successfully";
    }
}
