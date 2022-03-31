package com.example.demo.dto;

import java.util.List;

public class LeaveDetailsResponseDto {

  private int employeeId;
  private String employeeName;
  private List<LeaveTypeResponseDto> leaveList;
 

  public List<LeaveTypeResponseDto> getLeaveList() {
    return leaveList;
  }

  public void setLeaveList(List<LeaveTypeResponseDto> leaveList) {
    this.leaveList = leaveList;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

}
