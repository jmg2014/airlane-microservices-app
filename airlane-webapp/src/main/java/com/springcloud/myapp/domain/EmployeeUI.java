package com.springcloud.myapp.domain;

import java.util.HashSet;
import java.util.Set;

public class EmployeeUI {

  private Integer selectedCustomerId;
  private Set<Position> customerSet = new HashSet<Position>();


  public Integer getSelectedCustomerId() {
    return selectedCustomerId;
  }

  public void setSelectedCustomerId(Integer selectedCustomerId) {
    this.selectedCustomerId = selectedCustomerId;
  }

  public Set<Position> getCustomerSet() {
    return customerSet;
  }

  public void setCustomerSet(Set<Position> customerSet) {
    this.customerSet = customerSet;
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
