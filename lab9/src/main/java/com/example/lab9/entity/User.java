package com.example.lab9.entity;


import jakarta.persistence.*;
import java.util.Objects; // Needed for equals() and hashCode()

@Entity
@Table(name = "user") // Explicitly naming the table 'user'
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated primary key

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    // --- Manually Added Code (Replaces Lombok) ---

    // No-argument constructor (required by JPA)
    public User() {
    }

    // Constructor with essential fields (useful for creating new users without ID)
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Optional: equals() and hashCode() - Good practice for entities
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        // Use ID for comparison if available and non-null, otherwise rely on other fields
        if (id != null && user.id != null) {
            return Objects.equals(id, user.id);
        }
        return Objects.equals(name, user.name) &&
               Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        // Use ID for hashcode if available and non-null
        if (id != null) {
            return Objects.hash(id);
        }
        return Objects.hash(name, email);
    }

    // Optional: toString() - Useful for logging
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    // --- End of Manually Added Code ---
}