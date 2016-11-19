package com.springcloud.myapp.employee.api.v1;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.springcloud.myapp.employee.domain.Position;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PositionController.class)
public class PositionControllerTest {

  @MockBean
  private PositionService positionService;


  @Autowired
  private MockMvc mockMvc;

  private Position captain;

  @Before
  public void setUp() {


    captain = new Position();
    captain.setId(123L);
    captain.setVersion(1);
    captain.setDescription("Captain");


  }

  @Test
  public void testGetPosition() throws Exception {

    given(positionService.getPosition(123L)).willReturn(captain);

    mockMvc.perform(get("/v1/employee-service/position/{positionId}", new Long(123L)))
        .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(123)))
        .andExpect(jsonPath("$.version", is(1)))
        .andExpect(jsonPath("$.description", is("Captain")));

  }


  @Test
  public void testPositions() throws Exception {

    List<Position> positions = new ArrayList<Position>();

    positions.add(captain);


    Iterable<Position> iterable = () -> positions.iterator();

    given(positionService.getPositions()).willReturn(iterable);
    mockMvc.perform(get("/v1/employee-service/positions")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id", is(123))).andExpect(jsonPath("$[0].version", is(1)))
        .andExpect(jsonPath("$[0].description", is("Captain")));

  }


}
