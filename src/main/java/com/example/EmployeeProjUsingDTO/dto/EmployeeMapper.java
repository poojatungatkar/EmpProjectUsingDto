package com.example.EmployeeProjUsingDTO.dto;

import com.example.EmployeeProjUsingDTO.entity.Employee;
import org.springframework.stereotype.Component;


public class EmployeeMapper
{
    //map data employeeDto to Employee
    public static Employee mapToEmployee(EmployeeDto dto)
    {
        return  new Employee(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail() ,
                dto.getAddress());
    }

    //map data Employee to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
        employee.getAddress());
    }
}
