package com.example.Shops.Service;

import com.example.Shops.Models.Admins;
import com.example.Shops.Models.Customers;
import com.example.Shops.Models.Users;
import com.example.Shops.Repository.AdminRepository;
import com.example.Shops.Repository.CustomersRepository;
import com.example.Shops.Repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private CustomersRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    public void createUsers(Users users) {
//        usersRepository.save(users);
//    }
//
//    public void deleteUsers(long id) {
//        usersRepository.deleteById(id);
//    }
//
//    public List<Users> findAllUsers() {
//        return usersRepository.findAll();
//    }
//
//
//    public void updateUsers(long id, Users user) throws Exception {
//        Optional<Users> oldUser = usersRepository.findById(id);
//
//        if (oldUser.isPresent()) {
//            if (user.getUsername() != null) {
//                oldUser.get().setUsername(user.getUsername());
//            }
//
//            if (user.getPassword() != null) {
//                oldUser.get().setPassword(user.getPassword());
//            }
//
//            if (user.getEmail() != null) {
//                oldUser.get().setEmail(user.getEmail());
//            }
//            usersRepository.save(oldUser.get());
//        }
//        else {
//            Exception ex = new Exception("User with id " + id + " is not found");
//            throw ex;
//        }
//    }

    public String signupCustomer(String username, String password) {
        if (customerRepository.findByUsername(username) != null) {
            return "Username already taken!";
        }
        if (!username.endsWith("@gmail.com")) {
            return " Email must end with @gmail.com!";
        }

        Customers customer = new Customers();
        customer.setUsername(username);
        customer.setPassword(passwordEncoder.encode(password));
        customer.isUserCustomer(true);// Hash password
        customer.setCreatedDate(new Date());
        customerRepository.save(customer);

        return "Customer signup successful!";
    }

    public String signupAdmin(String username, String password) {
        if (adminRepository.findByUsername(username) != null) {
            return "Username already taken!";
         }
        if (username.endsWith("@Admin.gmail.com"))
         {
            Admins admin = new Admins();
            admin.setUsername(username);
            admin.setPassword(passwordEncoder.encode(password)); // Hash password
            admin.isUserCustomer(false);
            admin.setCreatedDate(new Date());
            adminRepository.save(admin);
         }
           else {
                    return "Admins Emails must end with Specific format";
                }


            return "Admin signup successful!";
    }

    public Users login(String username, String password) {
        Users user = customerRepository.findByUsername(username);
        if (user == null) {
            user = adminRepository.findByUsername(username);

        }
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user; // Return user for successful login
        }

        return null; // Invalid credentials
    }
}
