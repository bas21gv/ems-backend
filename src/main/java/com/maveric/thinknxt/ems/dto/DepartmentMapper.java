package com.maveric.thinknxt.ems.dto;

import com.maveric.thinknxt.ems.document.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .build();
    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return Department.builder()
                .id(departmentDto.getId())
                .departmentName(departmentDto.getDepartmentName())
                .departmentDescription(departmentDto.getDepartmentDescription())
                .build();
    }
}
