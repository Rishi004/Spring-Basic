package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LEAVE_REQUEST")
public class LeaveRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String reason;
  private int days;
  
  @ManyToOne
  @JoinColumn(name = "employee_leaveType_id")
  private EmployeeLeaveType employeeLeaveType;

 
}
