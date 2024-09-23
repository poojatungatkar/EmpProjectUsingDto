package com.example.EmployeeProjUsingDTO.controller;

import com.example.EmployeeProjUsingDTO.dto.EmployeeDto;
import com.example.EmployeeProjUsingDTO.dto.EmployeeMapper;
import com.example.EmployeeProjUsingDTO.entity.Employee;
import com.example.EmployeeProjUsingDTO.exception.ResourceNotFoundException;
import com.example.EmployeeProjUsingDTO.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String home()
    {
        return "welcome to employee..!";
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto saveEmp=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer id) throws ResourceNotFoundException
    {
        EmployeeDto dto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> list=employeeService.getAllEmployee();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id,
                                                      @RequestBody EmployeeDto empDto) throws ResourceNotFoundException {
        EmployeeDto dto=employeeService.updateEmployee(id,empDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeDto> findByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
        return new ResponseEntity<>(employeeService.findEmployeeByEmail(email),HttpStatus.FOUND);
    }
}
