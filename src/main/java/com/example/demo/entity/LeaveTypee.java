package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_TYPEE")
public class LeaveTypee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String leaveTypee;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLeaveTypee() {
    return leaveTypee;
  }

  public void setLeaveTypee(String leaveTypee) {
    this.leaveTypee = leaveTypee;
  }



}
