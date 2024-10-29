package com.example.Shops.Repository;

import com.example.Shops.Models.Admins;
import com.example.Shops.Models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    Customers findByUsername(String username);
}

