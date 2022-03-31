package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LeaveTypee;

public interface LeaveTypeeService {

  public LeaveTypee saveTypee(LeaveTypee leaveTypee);

  public List<LeaveTypee> getAllTypees();

  public LeaveTypee updateTypee(LeaveTypee leaveTypee);

  public String deleteTypee(int id);
}
