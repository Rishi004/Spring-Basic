package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.LeaveDetailsDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveDetails;
import com.example.demo.entity.LeaveType;
import com.example.demo.mapper.Mapper;
import com.example.demo.responses.ValidationFailureResponses;
import com.example.demo.service.LeaveDetailsService;
import com.example.demo.utils.Msg;
import com.example.demo.utils.ValidationFailureStatusCode;

@RestController
public class LeaveDetailsController {

  @Autowired
  private LeaveDetailsService leaveDetailsService;

  @Autowired
  private Mapper mapper;

  @Autowired
  private ValidationFailureStatusCode validationFailureStatusCode;

  @PostMapping("/rest/add/leaveDetails")
  public ResponseEntity<Object> addLeaveDetails(@RequestBody LeaveDetailsDto leaveDetailsDto) {
    if (!leaveDetailsService.checkCount(leaveDetailsDto.getEmployeeId(),
        leaveDetailsDto.getLeaveTypeId(), leaveDetailsDto.getDays())) {
      return new ResponseEntity<>(new ValidationFailureResponses(Msg.LEAVE_COUNT_ZERO,
          validationFailureStatusCode.getLeaveCountZero()), HttpStatus.BAD_REQUEST);
    }
    LeaveDetails leaveDetails = new LeaveDetails();
    leaveDetails.setReason(leaveDetailsDto.getReason());
    leaveDetails.setDays(leaveDetailsDto.getDays());

    Employee employee = new Employee();
    employee.setId(leaveDetailsDto.getEmployeeId());
    leaveDetails.setEmployee(employee);

    LeaveType leaveType = new LeaveType();
    leaveType.setId(leaveDetailsDto.getLeaveTypeId());
    leaveDetails.setLeaveType(leaveType);

    leaveDetailsService.saveDetails(leaveDetails);
    return new ResponseEntity<Object>(Msg.LEAVE_DETAILS_ADD_SUCCESS, HttpStatus.OK);
  }

  @GetMapping("/rest/get/leaveDetails")
  public ResponseEntity<Object> getAllLeaveDetails() {
    return new ResponseEntity<>(
        mapper.map(leaveDetailsService.getAllDetails(), LeaveDetailsDto.class), HttpStatus.OK);
  }

  @GetMapping("/rest/get/leaveBal/{empId}")
  public ResponseEntity<Object> getLeaveBalance(@PathVariable int empId) {
    return new ResponseEntity<>(leaveDetailsService.leaveBal(empId), HttpStatus.OK);
  }



}
