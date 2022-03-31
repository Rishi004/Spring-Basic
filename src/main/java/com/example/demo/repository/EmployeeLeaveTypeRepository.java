package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.EmployeeLeaveType;

@Repository
public interface EmployeeLeaveTypeRepository extends JpaRepository<EmployeeLeaveType, Integer> {

}
