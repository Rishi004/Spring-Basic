package com.example.demo.service;

import com.example.demo.entity.EmployeeLeaveType;

public interface EmployeeLeaveTypeService {
  public EmployeeLeaveType getByEmployeeLeaveTypeId(int id);

  public void updateRemainDays(EmployeeLeaveType empLtyDet);
}
