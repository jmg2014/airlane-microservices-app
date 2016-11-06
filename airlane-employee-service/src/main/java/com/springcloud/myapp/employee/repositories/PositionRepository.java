package com.springcloud.myapp.employee.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springcloud.myapp.employee.domain.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {

}
