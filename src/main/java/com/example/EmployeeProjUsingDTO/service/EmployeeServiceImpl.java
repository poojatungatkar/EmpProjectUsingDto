package com.example.EmployeeProjUsingDTO.service;

import com.example.EmployeeProjUsingDTO.dto.EmployeeDto;
import com.example.EmployeeProjUsingDTO.dto.EmployeeMapper;
import com.example.EmployeeProjUsingDTO.entity.Employee;
import com.example.EmployeeProjUsingDTO.exception.ResourceNotFoundException;
import com.example.EmployeeProjUsingDTO.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepo repo;

    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmp=repo.save(employee);
        System.out.println("save emp");
        return EmployeeMapper.mapToEmployeeDto(saveEmp);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) throws ResourceNotFoundException
    {
        Employee emp=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with given id: "+id));
        EmployeeDto dto=EmployeeMapper.mapToEmployeeDto(emp);
        return dto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee()
    {
        List<Employee> emplist=repo.findAll();
        return emplist.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto updateEmp) throws ResourceNotFoundException {
        Employee employee=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+id));

        employee.setFirstName(updateEmp.getFirstName());
        employee.setLastName(updateEmp.getLastName());
        employee.setEmail(updateEmp.getEmail());

        Employee saveEmp=repo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmp);
    }

    @Override
    public void deleteEmployee(Integer id)
    {
      repo.deleteById(id);
    }

    @Override
    public EmployeeDto findEmployeeByEmail(String email) throws ResourceNotFoundException {
        Employee emp=repo.findByEmail(email);
        if(emp==null)
        {
            throw new ResourceNotFoundException("Employee not found with email: "+email);
        }
        return EmployeeMapper.mapToEmployeeDto(emp) ;
    }
}
