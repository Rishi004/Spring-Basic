package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LeaveRequest;

public interface LeaveRequestService {
  public LeaveRequest saveRequests(LeaveRequest leaveRequest);
  
  public List<LeaveRequest> getAllRequests();

    
}
