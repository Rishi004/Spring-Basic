package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveRequestDto {

  private int id;
  private String reason;
  private int days;
  private int employeeLeaveTypeId;


}
