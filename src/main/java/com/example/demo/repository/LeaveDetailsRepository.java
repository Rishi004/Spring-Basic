package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.LeaveDetails;

@Repository
public interface LeaveDetailsRepository extends JpaRepository<LeaveDetails, Integer> {

  List<LeaveDetails> findByEmployeeIdAndLeaveTypeId(int employeeId, int leaveTypeId);

}
