//package com.example.Shops.Controllers;
//
//import com.example.Shops.Models.Users;
//import com.example.Shops.Service.UsersService;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@Setter
//@Getter
//@AllArgsConstructor
//public class UsersController {
//
////   private final UsersService usersService;
////
////    @GetMapping("/")
////    public String getUsers() {
////        return "hello";
////    }
////
////    @PostMapping("/createUser")
////    public void createUser(@RequestBody Users user) {
////        usersService.createUsers(user);
////    }
////
////    @PostMapping("/{id}")
////    public void deleteUser(@PathVariable long id) {
////        usersService.deleteUsers(id);
////    }
////
////
////    @GetMapping("/findAllUsers")
////    public List<Users> findAllUsers() {
////       List<Users> usersList = usersService.findAllUsers();
////       return usersList;
////
////    }
////
////    @PutMapping("updateUsers/{id}")
////    public void updateUsers(@PathVariable long id, @RequestBody Users user) throws Exception {
////        usersService.updateUsers(id, user);
////    }
//}
