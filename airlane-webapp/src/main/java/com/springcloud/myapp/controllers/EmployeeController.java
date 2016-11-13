package com.springcloud.myapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.springcloud.myapp.domain.Employee;
import com.springcloud.myapp.domain.EmployeeUI;
import com.springcloud.myapp.domain.Position;

@Controller
public class EmployeeController {

  private RestTemplate restTemplate;


  @Autowired
  public EmployeeController(RestTemplate restTemplate) {

    this.restTemplate = restTemplate;

  }


  @GetMapping(value = "/employees")
  public String list(Model model) {

    Employee[] employees = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/employees"),
        Employee[].class);

    model.addAttribute("employees", employees);

    return "employees";
  }

  @GetMapping("employee/{id}")
  public String showEmployee(@PathVariable Long id, Model model) {

    Employee employee = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/employee/%s", id),
        Employee.class);

    model.addAttribute("employee", employee);
    return "employeeshow";
  }

  @GetMapping("employee/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {


    Employee e = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/employee/%s", id),
        Employee.class);
    EmployeeUI employee = new EmployeeUI();

    List<Position> positions = new ArrayList<Position>();

    Position currentPosition = e.getPosition();
    positions.add(currentPosition);

    Position[] p = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/positions"),
        Position[].class);


    for (Position position : p) {
      if (position.getId() != currentPosition.getId()) {
        positions.add(position);
      }
    }


    employee.setPositionSet(positions);
    employee.setName(e.getName());
    employee.setLastName(e.getLastName());
    employee.setId(id);


    model.addAttribute("employeeUI", employee);

    return "employeeform";
  }

  @PostMapping(value = "update")
  public String update(@Valid EmployeeUI employeeUI, BindingResult bindingResult, Model model) {


    Employee employee = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/employee/%s",
            employeeUI.getId()),
        Employee.class);


    employee.setName(employeeUI.getName());
    employee.setLastName(employeeUI.getLastName());

    Position position = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/position/%s",
            employeeUI.getSelectedPositionId()),
        Position.class);

    // employee.setPosition(positionService.getPositionById(employeeUI.getSelectedPositionId()));
    employee.setPosition(position);


    Employee e = restTemplate.postForObject(
        String.format("http://airlane-employee-service/v1/employee-service/save"), employee,
        Employee.class);
    // employeeService.saveEmployee(employee);

    return "redirect:/employee/" + e.getId();
  }

  @GetMapping("employee/new")
  public String newEmployee(Model model) {

    EmployeeUI employee = new EmployeeUI();

    List<Position> positions = new ArrayList<Position>();

    Position[] p = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/positions"),
        Position[].class);

    for (Position position : p) {
      positions.add(position);
    }

    employee.setPositionSet(positions);

    model.addAttribute("employeeUI", employee);

    return "employeenew";
  }

  @PostMapping(value = "employee")
  public String saveEmployee(@Valid EmployeeUI employeeUI, BindingResult bindingResult,
      Model model) {


    Employee newEmployee = new Employee();
    newEmployee.setName(employeeUI.getName());
    newEmployee.setLastName(employeeUI.getLastName());

    Position position = restTemplate.getForObject(
        String.format("http://airlane-employee-service/v1/employee-service/position/%s",
            employeeUI.getSelectedPositionId()),
        Position.class);

    // newEmployee.setPosition(positionService.getPositionById(employee.getSelectedPositionId()));
    newEmployee.setPosition(position);

    Employee e = restTemplate.postForObject(
        String.format("http://airlane-employee-service/v1/employee-service/save"), newEmployee,
        Employee.class);
    // employeeService.saveEmployee(newEmployee);

    return "redirect:/employee/" + e.getId();
  }

}
