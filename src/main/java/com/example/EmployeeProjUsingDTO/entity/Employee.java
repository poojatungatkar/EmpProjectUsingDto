package com.example.EmployeeProjUsingDTO.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Firstname should not null!")
    private String firstName;

    @NotBlank(message = "LastName should not null!")
    private String lastName;

    @NotBlank(message = "Email should not null!")
    @Email(message = "provide email in proper format")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Employee(Integer id, @NotBlank(message = "Firstname should not null!") String firstName, @NotBlank(message = "Lastname should not null!") String lastName, @NotBlank(message = "Email should not null!") @Email(message = "provide email in proper format") String email, Object o, Address address) {
    }
}
