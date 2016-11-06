package com.springcloud.myapp.employee.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springcloud.myapp.employee.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
