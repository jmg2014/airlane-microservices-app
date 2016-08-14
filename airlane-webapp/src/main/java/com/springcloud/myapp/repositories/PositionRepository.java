package com.springcloud.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springcloud.myapp.domain.Position;

public interface PositionRepository extends CrudRepository<Position, Integer> {

}
