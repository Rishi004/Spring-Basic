package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LeaveDetailsDto {
  
  @NotNull(message = "{leaveDetails.id.null}")
  @NotEmpty(message = "{leaveDetails.id.empty}")
  @NotBlank(message = "{leaveDetails.id.blank}")
  private int id;
  @NotNull(message = "{leaveDetails.reason.null}")
  @NotEmpty(message = "{leaveDetails.reason.empty}")
  @NotBlank(message = "{leaveDetails.reason.blank}")
  private String reason;
  @NotNull(message = "{leaveDetails.days.null}")
  @NotEmpty(message = "{leaveDetails.days.empty}")
  @NotBlank(message = "{leaveDetails.days.blank}")
  private int days;
  private int employeeId;
  private int leaveTypeId;

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public int getLeaveTypeId() {
    return leaveTypeId;
  }

  public void setLeaveTypeId(int leaveTypeId) {
    this.leaveTypeId = leaveTypeId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }

}
