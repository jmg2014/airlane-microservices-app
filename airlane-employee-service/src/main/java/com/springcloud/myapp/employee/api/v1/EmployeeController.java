package com.springcloud.myapp.employee.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.myapp.employee.domain.Employee;


@RestController
@RequestMapping(path = "/v1/employee-service")
public class EmployeeController {

  private EmployeeService employeeService;


  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }


  @GetMapping(value = "/employee/{employeeId}")
  public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
    return Optional.ofNullable(employeeService.getEmployee(employeeId))
        .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @GetMapping(value = "/employees")
  public ResponseEntity<Iterable<Employee>> getEmployees() {
    return Optional.ofNullable(employeeService.getEmployees())
        .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
  }


  @PostMapping(value = "/save")
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws Exception {
    assert employee != null;

    return Optional.ofNullable(employeeService.save(employee))
        .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
        .orElseThrow(() -> new Exception("Could not save the employee"));
  }



}
