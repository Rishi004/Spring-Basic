package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeDto {
  @NotNull(message = "{employee.id.null}")
  @NotEmpty(message = "{employee.id.empty}")
  @NotBlank(message = "{employee.id.blank}")
  private int id;
  @NotNull(message = "{employee.name.null}")
  @NotEmpty(message = "{employee.name.empty}")
  @NotBlank(message = "{employee.name.blank}")
  private String name;
  private int casualTypeCount;
  private int annualTypeCount;

  public int getCasualTypeCount() {
    return casualTypeCount;
  }

  public void setCasualTypeCount(int casualTypeCount) {
    this.casualTypeCount = casualTypeCount;
  }

  public int getAnnualTypeCount() {
    return annualTypeCount;
  }

  public void setAnnualTypeCount(int annualTypeCount) {
    this.annualTypeCount = annualTypeCount;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
