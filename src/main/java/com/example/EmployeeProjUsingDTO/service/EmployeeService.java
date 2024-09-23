package com.example.EmployeeProjUsingDTO.service;

import com.example.EmployeeProjUsingDTO.dto.EmployeeDto;
import com.example.EmployeeProjUsingDTO.entity.Employee;
import com.example.EmployeeProjUsingDTO.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService
{
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Integer id) throws ResourceNotFoundException;
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Integer id,EmployeeDto updateEmp) throws ResourceNotFoundException;
    void deleteEmployee(Integer id);
    EmployeeDto findEmployeeByEmail(String email) throws ResourceNotFoundException;


}
