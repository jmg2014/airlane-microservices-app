package com.springcloud.myapp.services;


import com.springcloud.myapp.domain.Employee;

public interface EmployeeService {

  Iterable<Employee> listAllEmployees();

  Employee getEmployeeById(Integer id);

  Employee saveEmployee(Employee employee);
}
