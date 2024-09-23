package com.example.EmployeeProjUsingDTO.dto;

import com.example.EmployeeProjUsingDTO.entity.Employee;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto
{
    private Integer id;
    private String street;
    private String city;
    private String state;

}
