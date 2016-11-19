package com.springcloud.myapp.employee.api.v1;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcloud.myapp.employee.AirlaneEmployeeServiceApplication;
import com.springcloud.myapp.employee.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AirlaneEmployeeServiceApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeIT {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void saveEmployee() {

    Employee employee = new Employee();
    employee.setLastName("Doe");

    ResponseEntity<Employee> responseEntity =
        restTemplate.postForEntity("/v1/employee-service/save", employee, Employee.class);
    Employee responseEmployee = responseEntity.getBody();

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Doe", responseEmployee.getLastName());
  }

  @Test
  public void getEmployee() {

    ResponseEntity<Employee> responseEntity =
        restTemplate.getForEntity("/v1/employee-service/employee/1", Employee.class);
    Employee responseEmployee = responseEntity.getBody();

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Joe", responseEmployee.getName());
  }

}
