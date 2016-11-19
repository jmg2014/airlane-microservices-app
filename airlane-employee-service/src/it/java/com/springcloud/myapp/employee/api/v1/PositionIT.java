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
import com.springcloud.myapp.employee.domain.Position;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AirlaneEmployeeServiceApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PositionIT {

  @Autowired
  private TestRestTemplate restTemplate;


  @Test
  public void getPosition() {

    ResponseEntity<Position> responseEntity =
        restTemplate.getForEntity("/v1/employee-service/position/1", Position.class);
    Position responsePosition = responseEntity.getBody();

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Captain", responsePosition.getDescription());
  }

}
