package com.dig.leavemgmt.service;

import com.dig.leavemgmt.model.DesignationDto;

import java.util.List;

public interface DesignationService {
    public DesignationDto createDesignation(DesignationDto designationDto);
    public DesignationDto updateDesignation(DesignationDto designationDto);
    public DesignationDto getDesignationById(Long designationId);
    public List<DesignationDto> getAllDesignations();
    public String deleteDesignation(Long designationId);
}
