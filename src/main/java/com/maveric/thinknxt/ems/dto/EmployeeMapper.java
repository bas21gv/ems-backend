package com.maveric.thinknxt.ems.dto;

import com.maveric.thinknxt.ems.document.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .build();
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentId(employee.getDepartment().getId())
                .build();
    }
}
