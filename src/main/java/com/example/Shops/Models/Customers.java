package com.example.Shops.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customers extends Users  {

    public boolean isUserCustomer(boolean b) {
            return true;
    }
}
