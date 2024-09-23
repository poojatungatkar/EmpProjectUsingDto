package com.example.EmployeeProjUsingDTO.dto;

import com.example.EmployeeProjUsingDTO.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto
{
    private Integer id;

    @NotBlank(message = "Firstname should not null!")
    private String firstName;

    @NotBlank(message = "Lastname should not null!")
    private String lastName;

    @NotBlank(message = "Email should not null!")
    @Email(message = "provide email in proper format")
    private String email;

    private Address address;

    public EmployeeDto(Integer id, @NotBlank(message = "Firstname should not null!") String firstName, @NotBlank(message = "LastName should not null!") String lastName, @NotBlank(message = "Email should not null!") @Email(message = "provide email in proper format") String email, Object o, Address address) {
    }
}
