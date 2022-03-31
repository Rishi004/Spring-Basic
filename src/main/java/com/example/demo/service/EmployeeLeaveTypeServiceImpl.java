package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.EmployeeLeaveType;
import com.example.demo.repository.EmployeeLeaveTypeRepository;

@Service
public class EmployeeLeaveTypeServiceImpl implements EmployeeLeaveTypeService {

  @Autowired
  private EmployeeLeaveTypeRepository employeeLeaveTypeRepository;

  @Transactional(readOnly = true)
  public EmployeeLeaveType getByEmployeeLeaveTypeId(int id) {
    return employeeLeaveTypeRepository.findById(id).get();
  }

  @Transactional
  public void updateRemainDays(EmployeeLeaveType empLtyDet) {
    employeeLeaveTypeRepository.save(empLtyDet);
  }

}
