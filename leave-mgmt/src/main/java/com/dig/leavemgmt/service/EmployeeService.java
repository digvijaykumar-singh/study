package com.dig.leavemgmt.service;

import com.dig.leavemgmt.entity.Test;
import com.dig.leavemgmt.model.EmployeeDto;
import com.dig.leavemgmt.model.TestDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto updateEmployee(EmployeeDto employeeDto);
    public String deleteEmployee(Long employeeId);
    public List<EmployeeDto> getAllEmployee(Integer pageNo,Integer pageSize,String sortBy);
    public EmployeeDto getEmployeeById(Long employeeId);

    Test createTest(Test test);

    List<TestDto> getAllTest();
}
