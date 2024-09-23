package com.example.EmployeeProjUsingDTO.repository;

import com.example.EmployeeProjUsingDTO.dto.EmployeeDto;
import com.example.EmployeeProjUsingDTO.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
    Employee findByEmail(String email);

}
