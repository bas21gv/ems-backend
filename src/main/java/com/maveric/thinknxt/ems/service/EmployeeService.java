package com.maveric.thinknxt.ems.service;

import com.maveric.thinknxt.ems.document.Department;
import com.maveric.thinknxt.ems.exception.ResourceNotFoundException;
import com.maveric.thinknxt.ems.document.Employee;
import com.maveric.thinknxt.ems.dto.EmployeeDto;
import com.maveric.thinknxt.ems.dto.EmployeeMapper;
import com.maveric.thinknxt.ems.repository.DepartmentRepository;
import com.maveric.thinknxt.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final SequenceGeneratorService sequenceGeneratorService;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employee.setId(sequenceGeneratorService.generateSequence(Employee.EMPLOYEES_SEQUENCE));
        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(()-> new ResourceNotFoundException("Department not exists by given id:"+employeeDto.getDepartmentId()));
        employee.setDepartment(department);
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with given Id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with given Id: "+employeeId));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(()-> new ResourceNotFoundException("Department not exists by given id:"+employeeDto.getDepartmentId()));
        employee.setDepartment(department);
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with given Id: "+employeeId));
        employeeRepository.delete(employee);
    }
}
