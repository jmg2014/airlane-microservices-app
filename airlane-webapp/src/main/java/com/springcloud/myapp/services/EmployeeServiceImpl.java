package com.springcloud.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.myapp.domain.Employee;
import com.springcloud.myapp.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;

  @Autowired
  public void setProductRepository(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Iterable<Employee> listAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeById(Integer id) {
    return employeeRepository.findOne(id);
  }

  @Override
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }
}
