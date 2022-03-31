package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_LEAVE_TYPE")
public class EmployeeLeaveType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int remainDays;
  
  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;
  
  @ManyToOne
  @JoinColumn(name = "leaveTypee_id")
  private LeaveTypee leaveTypee;

  public int getId() {
    return id;
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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public LeaveTypee getLeaveTypee() {
    return leaveTypee;
  }

  public void setLeaveTypee(LeaveTypee leaveTypee) {
    this.leaveTypee = leaveTypee;
  }
}
