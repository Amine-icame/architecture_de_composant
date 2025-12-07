package com.example.bank_service_graphql.service.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users") // "User" est un mot réservé dans certaines BD
public class User {
    @Id @GeneratedValue
    protected Long id;
    protected String username;
    protected String firstname;
    protected String lastname;

    public User(String username) { this.username = username; }
}
