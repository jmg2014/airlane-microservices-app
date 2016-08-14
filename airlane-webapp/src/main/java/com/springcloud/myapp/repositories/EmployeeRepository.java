package com.springcloud.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springcloud.myapp.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
