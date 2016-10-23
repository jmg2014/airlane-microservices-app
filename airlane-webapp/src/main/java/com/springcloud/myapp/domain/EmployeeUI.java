package com.springcloud.myapp.domain;

import java.util.List;
import java.util.ArrayList;

public class EmployeeUI {

  private Integer selectedPositionId;
  private List<Position> positionSet = new ArrayList<Position>();


  public Integer getSelectedPositionId() {
    return selectedPositionId;
  }

  public void setSelectedPositionId(Integer selectedPositionId) {
    this.selectedPositionId = selectedPositionId;
  }

  public List<Position> getPositionSet() {
    return positionSet;
  }

  public void setPositionSet(List<Position> positionSet) {
    this.positionSet = positionSet;
  }

  private Integer id;


  private Integer version;


  private String name;

  private String lastName;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }



}
