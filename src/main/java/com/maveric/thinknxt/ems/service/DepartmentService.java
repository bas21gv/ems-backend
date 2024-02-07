package com.maveric.thinknxt.ems.service;

import com.maveric.thinknxt.ems.document.Department;
import com.maveric.thinknxt.ems.dto.DepartmentDto;
import com.maveric.thinknxt.ems.dto.DepartmentMapper;
import com.maveric.thinknxt.ems.exception.ResourceNotFoundException;
import com.maveric.thinknxt.ems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.maveric.thinknxt.ems.document.Department.DEPARTMENT_SEQUENCE;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        department.setId(sequenceGeneratorService.generateSequence(DEPARTMENT_SEQUENCE));
        return DepartmentMapper.mapToDepartmentDto(departmentRepository.save(department));
    }

    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department not exists by given id:"+departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    public List<DepartmentDto> getAllDepartment() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    public DepartmentDto updateDepartmentById(Long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department not exists by given id:"+departmentId));
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return DepartmentMapper.mapToDepartmentDto(departmentRepository.save(department));
    }

    public void deleteDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department not exists by given id:"+departmentId));
        departmentRepository.delete(department);
    }
}
