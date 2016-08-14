package com.springcloud.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.myapp.domain.Position;
import com.springcloud.myapp.repositories.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {
  private PositionRepository positionRepository;

  @Autowired
  public void setPositionRepository(PositionRepository positionRepository) {
    this.positionRepository = positionRepository;
  }

  @Override
  public Iterable<Position> listAllPositions() {
    return positionRepository.findAll();
  }

  @Override
  public Position getPositionById(Integer id) {
    return positionRepository.findOne(id);
  }


}
