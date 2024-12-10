package com.employee.Employee_Details.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.employee.Employee_Details.Entity.Employee;
import com.employee.Employee_Details.dto.TaxDetails;
import com.employee.Employee_Details.repository.EmployeeRepository;
import com.employee.Employee_Details.service.TaxService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor 
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	@Autowired
	TaxService taxService = new TaxService();

    @PostMapping("/api/employees")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
        if (employeeRepository.existsByEmployeeId(employee.getEmployeeId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee ID must be unique");
        }
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully");
    }
    @GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<?> getTaxDetails(@PathVariable String employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        TaxDetails taxDetails = taxService.calculateTax(employee);
        return ResponseEntity.ok(taxDetails);
    }

}
