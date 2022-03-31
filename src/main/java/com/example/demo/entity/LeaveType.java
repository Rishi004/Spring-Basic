package com.example.demo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_TYPE")
public class LeaveType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String leaveType;
  private int count;
  
//  @ManyToMany
//  @JoinTable(name = "employee_leaveType_count",
//      joinColumns = @JoinColumn(name = "employee_leaveType_id"),
//      inverseJoinColumns = @JoinColumn(name = "employee_id"))
//  private List<Employee> employee;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(String leaveType) {
    this.leaveType = leaveType;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

}
