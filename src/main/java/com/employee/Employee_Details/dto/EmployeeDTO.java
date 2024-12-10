package com.employee.Employee_Details.dto;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class EmployeeDTO {
	@Pattern(regexp = "^E\\d{3}", message = "Employee ID must start with 'E' followed by 3 digits")
    private String employeeId;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotEmpty(message = "At least one phone number is required")
    private List<@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits") String> phoneNumbers;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in YYYY-MM-DD format")
    private String doj;

    @Positive(message = "Salary must be a positive number")
    private Double salary;

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public String getDoj() {
        return this.doj;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
