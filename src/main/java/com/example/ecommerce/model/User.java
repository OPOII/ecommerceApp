package com.example.ecommerce.model;

import com.example.ecommerce.utils.IdentityType;
import com.example.ecommerce.utils.UserRol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String secondName;
    private String lastName;
    private String username;
    private String identification;
    private String identificationNumber;
    private String email;
    private String direction;
    private String phone;
    private String rol;
    private String password;
    private boolean isActive;
    //Relationships
    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @OneToMany(mappedBy = "user")
    private List<Order>orders;
}
