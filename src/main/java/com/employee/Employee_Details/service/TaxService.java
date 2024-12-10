package com.employee.Employee_Details.service;

import org.springframework.stereotype.Service;

import com.employee.Employee_Details.Entity.Employee;
import com.employee.Employee_Details.dto.TaxDetails;

@Service
public class TaxService {
	public TaxDetails calculateTax(Employee employee) {
        double yearlySalary = employee.getSalary() * 12; 
        double tax = 0;

        if (yearlySalary > 250000) {
            if (yearlySalary <= 500000) {
                tax = (yearlySalary - 250000) * 0.05;
            } else if (yearlySalary <= 1000000) {
                tax = 250000 * 0.05 + (yearlySalary - 500000) * 0.10;
            } else {
                tax = 250000 * 0.05 + 500000 * 0.10 + (yearlySalary - 1000000) * 0.20;
            }
        }

        double cess = (yearlySalary > 2500000) ? (yearlySalary - 2500000) * 0.02 : 0;

        return new TaxDetails(
            employee.getEmployeeId(),
            employee.getFirstName(),
            employee.getLastName(),
            yearlySalary,
            tax,
            cess
        );
    }
}
