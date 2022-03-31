package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.LeaveDetailsResponseDto;
import com.example.demo.dto.LeaveTypeResponseDto;
import com.example.demo.entity.LeaveDetails;
import com.example.demo.entity.LeaveType;
import com.example.demo.repository.LeaveDetailsRepository;
import com.example.demo.repository.LeaveTypeRepository;

@Service
public class LeaveDetailsServiceImpl implements LeaveDetailsService {

  @Autowired
  private LeaveDetailsRepository leaveDetailsRepository;

  @Autowired
  private LeaveTypeRepository leaveTypeRepository;

  @Override
  public LeaveDetails saveDetails(LeaveDetails leaveDetails) {
    return leaveDetailsRepository.save(leaveDetails);
  }

  @Override
  public List<LeaveDetails> getAllDetails() {
    return leaveDetailsRepository.findAll();
  }

  @Override
  public boolean checkCount(int employeeId, int leaveTypeId, int days) {
    List<LeaveDetails> leaves =
        leaveDetailsRepository.findByEmployeeIdAndLeaveTypeId(employeeId, leaveTypeId);
    LeaveType leaveType = leaveTypeRepository.findById(leaveTypeId).get();
    int daysSum = 0;
    int count = leaveType.getCount();
    for (LeaveDetails levDet : leaves) {
      daysSum += levDet.getDays();
    }
    return daysSum + days <= count;
  }

  public LeaveDetailsResponseDto leaveBal(int employeeId) {
    List<LeaveType> leaveType = leaveTypeRepository.findAll();
    LeaveDetailsResponseDto detailsResponseDto = new LeaveDetailsResponseDto();
    List<LeaveTypeResponseDto> leaveList = new ArrayList<LeaveTypeResponseDto>();

    leaveType.forEach(lev -> {

      int daysSum = 0;

      List<LeaveDetails> leaves =
          leaveDetailsRepository.findByEmployeeIdAndLeaveTypeId(employeeId, lev.getId());
      LeaveTypeResponseDto leaveTypeResponseDto = new LeaveTypeResponseDto();
      for (LeaveDetails levDet : leaves) {
        detailsResponseDto.setEmployeeName(levDet.getEmployee().getName());
        detailsResponseDto.setEmployeeId(levDet.getEmployee().getId());
        leaveTypeResponseDto.setLeaveType(levDet.getLeaveType().getLeaveType());
        daysSum += levDet.getDays();
      }
      leaveTypeResponseDto.setCount(lev.getCount() - daysSum);
      leaveList.add(leaveTypeResponseDto);
    });
    detailsResponseDto.setLeaveList(leaveList);
    return detailsResponseDto;
  }


}
