package com.springcloud.myapp.services;


import com.springcloud.myapp.domain.Position;

public interface PositionService {

  Iterable<Position> listAllPositions();

  Position getPositionById(Integer id);

}
