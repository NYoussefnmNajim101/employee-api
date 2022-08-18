package com.example.employee.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String email;

}
