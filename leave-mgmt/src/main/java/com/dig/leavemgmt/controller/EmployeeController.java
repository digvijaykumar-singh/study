package com.dig.leavemgmt.controller;

import com.dig.leavemgmt.entity.Test;
import com.dig.leavemgmt.model.EmployeeDto;
import com.dig.leavemgmt.model.TestDto;
import com.dig.leavemgmt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("employees")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }

    @GetMapping("employees")
    public List<EmployeeDto> getAllEmployee( @RequestParam(defaultValue = "0") Integer pageNo,
                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                             @RequestParam(defaultValue = "employeeId") String sortBy){
        return employeeService.getAllEmployee(pageNo,pageSize,sortBy);
    }

    @GetMapping("employees/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

    @PostMapping("test")
    public Test createTest(@RequestBody Test test){
        return employeeService.createTest(test);
    }
    @GetMapping("test")
    public List<TestDto> getAllTest(){
        return employeeService.getAllTest();
    }

}
