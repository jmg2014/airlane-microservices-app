package com.springcloud.myapp.employee.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.myapp.employee.domain.Employee;
import com.springcloud.myapp.employee.repositories.EmployeeRepository;

@Service
public class EmployeeService {

  private EmployeeRepository employeeRepository;


  @Autowired
  public EmployeeService(EmployeeRepository employeeRepository) {

    this.employeeRepository = employeeRepository;

  }


  public Employee getEmployee(Long employeeId) {

    return employeeRepository.findOne(employeeId);

  }


  public Iterable<Employee> getEmployees() {

    return employeeRepository.findAll();

  }

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

}
