package com.example.Shops.Repository;

import com.example.Shops.Models.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admins, Long> {
    Admins findByUsername(String username);
}

