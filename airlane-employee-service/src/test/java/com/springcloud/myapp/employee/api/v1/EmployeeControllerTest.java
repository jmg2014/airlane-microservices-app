package com.springcloud.myapp.employee.api.v1;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.myapp.employee.domain.Employee;
import com.springcloud.myapp.employee.domain.Position;
import com.springcloud.myapp.employee.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

  @MockBean
  private EmployeeService employeeService;

  @MockBean
  private EmployeeRepository employeeRepository;


  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private Employee john;
  private Employee mary;

  @Before
  public void setUp() {

    john = new Employee();
    john.setName("John");
    john.setLastName("Doe");
    john.setId(123L);
    john.setVersion(1);
    Position position = new Position();
    position.setId(123L);
    position.setVersion(1);
    position.setDescription("Captain");

    john.setPosition(position);


    mary = new Employee();
    mary.setName("Mary");
    mary.setLastName("Does");
  }

  @Test
  public void testGetEmployee() throws Exception {

    given(employeeService.getEmployee(123L)).willReturn(john);

    mockMvc.perform(get("/v1/employee-service/employee/{employeeId}", new Long(123L)))
        .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(123)))
        .andExpect(jsonPath("$.name", is("John"))).andExpect(jsonPath("$.lastName", is("Doe")));

  }


  @Test
  public void testEmployees() throws Exception {

    List<Employee> employees = new ArrayList<Employee>();

    employees.add(john);
    employees.add(mary);

    Iterable<Employee> iterable = () -> employees.iterator();

    given(employeeService.getEmployees()).willReturn(iterable);
    mockMvc.perform(get("/v1/employee-service/employees")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id", is(123))).andExpect(jsonPath("$[0].name", is("John")))
        .andExpect(jsonPath("$[0].lastName", is("Doe")))
        .andExpect(jsonPath("$[1].lastName", is("Does")));
  }


  @Test
  public void testSaveEmployee() throws Exception {

    given(employeeService.save(john)).willReturn(john);
    mockMvc
        .perform(post("/v1/employee-service/save").content(objectMapper.writeValueAsBytes(john))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(123)))
        .andExpect(jsonPath("$.name", is("John"))).andExpect(jsonPath("$.lastName", is("Doe")));
  }
}
