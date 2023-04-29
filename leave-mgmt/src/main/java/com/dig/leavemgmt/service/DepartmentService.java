package com.dig.leavemgmt.service;

import com.dig.leavemgmt.entity.Department;
import com.dig.leavemgmt.model.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    public DepartmentDto createDepartment(DepartmentDto departmentDto);
    public DepartmentDto updateDepartment(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentById(Long departmentId);
    public List<DepartmentDto> getAllDepartments();
    public String deleteDepartment(Long departmentId);
}
