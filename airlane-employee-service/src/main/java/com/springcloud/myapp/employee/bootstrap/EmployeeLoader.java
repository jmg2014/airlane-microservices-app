package com.springcloud.myapp.employee.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springcloud.myapp.employee.domain.Employee;
import com.springcloud.myapp.employee.domain.Position;
import com.springcloud.myapp.employee.repositories.EmployeeRepository;
import com.springcloud.myapp.employee.repositories.PositionRepository;

@Component
public class EmployeeLoader implements ApplicationListener<ContextRefreshedEvent> {


  private PositionRepository positionRepository;

  private EmployeeRepository employeeRepository;

  private Logger log = Logger.getLogger(EmployeeLoader.class);

  @Autowired
  public void setPositionRepository(PositionRepository positionRepository) {

    this.positionRepository = positionRepository;
  }

  @Autowired
  public void setEmployeeRepository(EmployeeRepository employeeRepository) {

    this.employeeRepository = employeeRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    Position captain = new Position();
    captain.setDescription("Captain");
    positionRepository.save(captain);

    Position position = new Position();
    position.setDescription("First Officer");
    positionRepository.save(position);

    position = new Position();
    position.setDescription("Purser");
    positionRepository.save(position);

    Position flightAttendant = new Position();
    flightAttendant.setDescription("Flight attendant");
    positionRepository.save(flightAttendant);

    position = new Position();
    position.setDescription("Flight medic");
    positionRepository.save(position);

    position = new Position();
    position.setDescription("Loadmaster");
    positionRepository.save(position);



    Employee employee = new Employee();
    employee.setName("Joe");
    employee.setLastName("Doe");
    employee.setPosition(flightAttendant);

    employeeRepository.save(employee);

    Employee perryMason = new Employee();
    perryMason.setName("Perry");
    perryMason.setLastName("Mason");
    perryMason.setPosition(captain);
    employeeRepository.save(perryMason);



    log.info("Saved Positions");


  }
}
