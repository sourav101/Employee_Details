package com.employee.Employee_Details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.Employee_Details.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    boolean existsByEmployeeId(String employeeId);
    boolean existsByEmail(String email);
}
