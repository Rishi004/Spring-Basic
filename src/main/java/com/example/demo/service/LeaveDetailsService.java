package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.LeaveDetailsResponseDto;
import com.example.demo.entity.LeaveDetails;

public interface LeaveDetailsService {
  public LeaveDetails saveDetails(LeaveDetails leaveDetails);

  public List<LeaveDetails> getAllDetails();

  public boolean checkCount(int employeeId, int leaveTypeId, int days);
  
  public LeaveDetailsResponseDto leaveBal(int employeeId);
  
 
}
