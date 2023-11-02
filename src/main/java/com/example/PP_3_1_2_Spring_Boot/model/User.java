package com.example.PP_3_1_2_Spring_Boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z\\-]+$", message = "The name can only keep letters and a dash symbol.")
    @Size(min = 1, max = 50, message = "The name must be between 1 and 50 characters long")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Surname is required")
    @Pattern(regexp = "^[a-zA-Z\\-]+$", message = "The family can only keep letters and a dash symbol.")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters long")
    private String surname;

    @Column(name = "age")
    @Digits(integer = 3, fraction = 0, message = "Age must be a numeric value")
    @NotNull(message = "Age cannot be empty")
    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 100, message = "Age must be at most 100")
    private int age;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
