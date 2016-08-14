package com.springcloud.myapp.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springcloud.myapp.domain.Employee;
import com.springcloud.myapp.domain.EmployeeUI;
import com.springcloud.myapp.domain.Position;
import com.springcloud.myapp.services.EmployeeService;
import com.springcloud.myapp.services.PositionService;

@Controller
public class EmployeeController {

  private EmployeeService employeeService;

  private PositionService positionService;

  @Autowired
  public void setEmployeeService(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @Autowired
  public void setPositionService(PositionService positionService) {
    this.positionService = positionService;
  }

  @GetMapping(value = "/employees")
  public String list(Model model) {
    model.addAttribute("employees", employeeService.listAllEmployees());
    return "employees";
  }

  @GetMapping("employee/{id}")
  public String showEmployee(@PathVariable Integer id, Model model) {
    model.addAttribute("employee", employeeService.getEmployeeById(id));
    return "employeeshow";
  }

  @GetMapping("employee/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("employee", employeeService.getEmployeeById(id));
    return "employeeform";
  }

  @GetMapping("employee/new")
  public String newEmployee(Model model) {

    EmployeeUI employee = new EmployeeUI();

    Set<Position> positions = new HashSet<Position>();

    for (Position position : positionService.listAllPositions()) {
      positions.add(position);
    }

    employee.setCustomerSet(positions);

    model.addAttribute("employeeUI", employee);

    return "employeenew";
  }

  @PostMapping(value = "employee")
  public String saveEmployee(@Valid EmployeeUI employee, BindingResult bindingResult, Model model) {


    Employee newEmployee = new Employee();
    newEmployee.setName(employee.getName());
    newEmployee.setLastName(employee.getLastName());
    newEmployee.setPosition(positionService.getPositionById(employee.getSelectedCustomerId()));

    employeeService.saveEmployee(newEmployee);

    return "redirect:/employee/" + newEmployee.getId();
  }

}
