package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.LeaveRequest;
import com.example.demo.repository.LeaveRequestRepository;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

  @Autowired
  private LeaveRequestRepository leaveRequestRepository;

  @Override
  public LeaveRequest saveRequests(LeaveRequest leaveRequest) {
    return leaveRequestRepository.save(leaveRequest);
  }

  @Override
  public List<LeaveRequest> getAllRequests() {
    return leaveRequestRepository.findAll();
  }


}
