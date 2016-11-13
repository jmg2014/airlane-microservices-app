package com.springcloud.myapp.employee.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcloud.myapp.employee.domain.Employee;
import com.springcloud.myapp.employee.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Test

  public void testFindAircrew() {

    Employee employee = new Employee();
    employee.setName("John");

    Employee e = entityManager.persist(employee);
    Employee aircrew = employeeRepository.findOne(e.getId());

    assertEquals("John", aircrew.getName());

  }

}
