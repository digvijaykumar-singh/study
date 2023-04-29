package com.dig.leavemgmt.controller;

import com.dig.leavemgmt.model.DepartmentDto;
import com.dig.leavemgmt.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("departments")
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.createDepartment(departmentDto);
    }

    @PutMapping("departments")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.updateDepartment(departmentDto);
    }

    @GetMapping("departments")
    public List<DepartmentDto> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("departments/{departmentId}")
    public DepartmentDto getDepartmentById(@PathVariable("departmentId") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") Long departmentId){
        return departmentService.deleteDepartment(departmentId);
    }
}
