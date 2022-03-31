package com.example.demo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.LeaveRequestDto;
import com.example.demo.entity.EmployeeLeaveType;
import com.example.demo.entity.LeaveRequest;
import com.example.demo.mapper.Mapper;
import com.example.demo.service.EmployeeLeaveTypeService;
import com.example.demo.service.LeaveRequestService;
import com.example.demo.utils.Msg;

@RestController
public class LeaveRequestController {

  @Autowired
  private LeaveRequestService leaveRequestService;

  @Autowired
  private EmployeeLeaveTypeService employeeLeaveTypeService;

  @Autowired
  private Mapper mapper;


  @PostMapping("/rest/add/leaveRequest")
  public ResponseEntity<Object> addLeaveRequest(@RequestBody LeaveRequestDto leaveRequestDto) {
    LeaveRequest leaveRequest = new LeaveRequest();
    leaveRequest.setDays(leaveRequestDto.getDays());
    leaveRequest.setReason(leaveRequestDto.getReason());

    EmployeeLeaveType employeeLeaveType = new EmployeeLeaveType();
    employeeLeaveType.setId(leaveRequestDto.getEmployeeLeaveTypeId());
    leaveRequest.setEmployeeLeaveType(employeeLeaveType);

    EmployeeLeaveType empLtyDet =
        employeeLeaveTypeService.getByEmployeeLeaveTypeId(leaveRequestDto.getEmployeeLeaveTypeId());
    empLtyDet.setRemainDays(empLtyDet.getRemainDays() - leaveRequestDto.getDays());
    employeeLeaveTypeService.updateRemainDays(empLtyDet);

    leaveRequestService.saveRequests(leaveRequest);
    return new ResponseEntity<Object>(Msg.LEAVE_REQUEST_ADD_SUCCESS, HttpStatus.OK);
  }

  @GetMapping("/rest/get/leaveRequests")
  public ResponseEntity<Object> getAllLeaveRequests() {
    return new ResponseEntity<>(
        mapper.map(leaveRequestService.getAllRequests(), LeaveRequestDto.class), HttpStatus.OK);

  }

  @GetMapping("/rest/getAllEmployeeLeaveById/{id}")
  public EmployeeLeaveType getAllEmployeeLeaveById(@Valid @PathVariable int id) {
    return employeeLeaveTypeService.getByEmployeeLeaveTypeId(id);
  }

}
