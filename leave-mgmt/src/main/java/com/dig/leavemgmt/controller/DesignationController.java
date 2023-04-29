package com.dig.leavemgmt.controller;

import com.dig.leavemgmt.model.DesignationDto;
import com.dig.leavemgmt.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping("designations")
    public DesignationDto createDesignation(@RequestBody DesignationDto designationDto){
        return designationService.createDesignation(designationDto);
    }

    @PutMapping("designations")
    public DesignationDto updateDesignation(@RequestBody DesignationDto designationDto){
        return designationService.updateDesignation(designationDto);
    }

    @GetMapping("designations")
    public List<DesignationDto> getAllDesignations(){
        return designationService.getAllDesignations();
    }

    @GetMapping("designations/{DesignationId}")
    public DesignationDto getDesignationById(@PathVariable("DesignationId") Long designationId){
        return designationService.getDesignationById(designationId);
    }

    @DeleteMapping("designations/{DesignationId}")
    public String deleteDesignation(@PathVariable("DesignationId") Long designationId){
        return designationService.deleteDesignation(designationId);
    }
}
