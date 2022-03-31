package com.example.demo.dto;


public class EmployeeLeaveTypeDto {

  private int id;
  private int remainDays;
  private int employeeId;
  private int leaveTypeeId;

  public int getId() {
    return id;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public int getLeaveTypeeId() {
    return leaveTypeeId;
  }

  public void setLeaveTypeeId(int leaveTypeeId) {
    this.leaveTypeeId = leaveTypeeId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRemainDays() {
    return remainDays;
  }

  public void setRemainDays(int remainDays) {
    this.remainDays = remainDays;
  }

}
