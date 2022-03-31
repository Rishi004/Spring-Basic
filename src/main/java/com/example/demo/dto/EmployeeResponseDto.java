package com.example.demo.dto;

public class EmployeeResponseDto {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
