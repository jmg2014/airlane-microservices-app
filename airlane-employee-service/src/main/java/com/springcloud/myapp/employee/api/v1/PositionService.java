package com.springcloud.myapp.employee.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.myapp.employee.domain.Position;
import com.springcloud.myapp.employee.repositories.PositionRepository;

@Service
public class PositionService {

  private PositionRepository positionRepository;


  @Autowired
  public PositionService(PositionRepository positionRepository) {

    this.positionRepository = positionRepository;

  }


  public Position getPosition(Long positionId) {

    return positionRepository.findOne(positionId);

  }


  public Iterable<Position> getPositions() {

    return positionRepository.findAll();

  }


}
