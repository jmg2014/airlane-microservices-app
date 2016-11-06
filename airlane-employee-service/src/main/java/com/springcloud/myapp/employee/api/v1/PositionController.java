package com.springcloud.myapp.employee.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.myapp.employee.domain.Position;


@RestController
@RequestMapping(path = "/v1/employee-service")
public class PositionController {

  private PositionService positionService;

  @Autowired
  public PositionController(PositionService positionService) {
    this.positionService = positionService;
  }


  @GetMapping(value = "/position/{positionId}")
  public ResponseEntity<Position> getPosition(@PathVariable Long positionId) {
    return Optional.ofNullable(positionService.getPosition(positionId))
        .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping(value = "/positions")
  public ResponseEntity<Iterable<Position>> getPositions() {
    return Optional.ofNullable(positionService.getPositions())
        .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }



}
