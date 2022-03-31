package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.LeaveTypee;
import com.example.demo.repository.LeaveTypeeRepository;

@Service
public class LeaveTypeeServiceImpl implements LeaveTypeeService {

  @Autowired
  private LeaveTypeeRepository leaveTypeeRepository;

  @Transactional
  public LeaveTypee saveTypee(LeaveTypee leaveTypee) {
    return leaveTypeeRepository.save(leaveTypee);
  }

  @Override
  public List<LeaveTypee> getAllTypees() {
    return leaveTypeeRepository.findAll();
  }

  @Transactional
  public LeaveTypee updateTypee(LeaveTypee leaveTypee) {
    LeaveTypee existingType = leaveTypeeRepository.findById(leaveTypee.getId()).orElse(null);
    existingType.setId(leaveTypee.getId());
    return leaveTypeeRepository.save(leaveTypee);
  }

  @Transactional
  public String deleteTypee(int id) {
    leaveTypeeRepository.deleteById(id);
    return "Typee Deleted Successfully";
  }


}
