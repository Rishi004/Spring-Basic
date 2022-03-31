package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.LeaveTypeeDto;
import com.example.demo.entity.LeaveTypee;
import com.example.demo.mapper.Mapper;
import com.example.demo.service.LeaveTypeeService;
import com.example.demo.utils.Msg;

@RestController
public class LeaveTypeeController {

  @Autowired
  private LeaveTypeeService leaveTypeeService;

  @Autowired
  private Mapper mapper;

  @PostMapping("/rest/add/leaveType")
  public ResponseEntity<Object> addLeaveTypee(@RequestBody LeaveTypeeDto leaveTypeeDto) {
    LeaveTypee leaveTypee = new LeaveTypee();
    leaveTypee.setLeaveTypee(leaveTypeeDto.getLeaveType());
    leaveTypeeService.saveTypee(leaveTypee);
    return new ResponseEntity<Object>(Msg.LEAVE_TYPE_ADD_SUCCESS, HttpStatus.OK);
  }

  @GetMapping("/rest/get/leaveTypees")
  public ResponseEntity<Object> getAllLeaveTypees() {
    return new ResponseEntity<>(mapper.map(leaveTypeeService.getAllTypees(), LeaveTypeeDto.class),
        HttpStatus.OK);
  }

  @PutMapping("/rest/update/leaveTypee")
  public ResponseEntity<Object> updateLeaveTypee(LeaveTypeeDto leaveTypeeDto) {
    leaveTypeeService.updateTypee(mapper.map(leaveTypeeDto, LeaveTypee.class));
    return new ResponseEntity<>(Msg.LEAVE_TYPE_UPDATE_SUCCESS, HttpStatus.OK);
  }

  @DeleteMapping("/rest/delete/leaveTypee/{id}")
  public ResponseEntity<Object> deleteLeaveTypee(@PathVariable int id) {
    leaveTypeeService.deleteTypee(id);
    return new ResponseEntity<Object>(Msg.LEAVE_TYPE_DELETE_SUCCESS, HttpStatus.OK);
  }


}
