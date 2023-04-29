package com.dig.leavemgmt.service.impl;

import com.dig.leavemgmt.entity.Designation;
import com.dig.leavemgmt.exception.NoSuchRecordFoundException;
import com.dig.leavemgmt.exception.ServiceException;
import com.dig.leavemgmt.model.DesignationDto;
import com.dig.leavemgmt.repository.DesignationRepository;
import com.dig.leavemgmt.service.DesignationService;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class DesignationServiceImpl  implements DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public DesignationDto createDesignation(DesignationDto designationDto) {
        try {
            return Designation.toDto(designationRepository.save(Designation.toEntity(designationDto)));
        }catch (Exception e){
            log.error("exception occurred while creating employee ",e);
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public DesignationDto updateDesignation(DesignationDto designationDto) {
        try {
            Designation designation=designationRepository.findById(designationDto.getDesignationId()).orElse(null);
            if(designation==null)
                throw new NoSuchRecordFoundException("NO DESIGNATION PRESENT WITH ID = "+designationDto.getDesignationId());
            //need to change here
            return Designation.toDto(designationRepository.save(Designation.toEntity(designationDto)));
        }
        catch (NoSuchRecordFoundException e){
            log.error("NO DESIGNATION PRESENT WITH ID =  ",designationDto.getDesignationId());
            throw  e;
        }
        catch (Exception e){
            log.error("exception occurred in updateDepartment() ",e);
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public DesignationDto getDesignationById(Long designationId) {
        try {
            return Designation.toDto(designationRepository.findById(designationId).orElseThrow(
                    () -> new NoSuchRecordFoundException("NO DESIGNATION PRESENT WITH ID = " + designationId)));
        } catch (NoSuchRecordFoundException e){
            log.error("NO DESIGNATION PRESENT WITH ID =  ",designationId);
            throw  e;
        }
        catch (Exception e){
            log.error("something went wrong in getDepartmentById() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public List<DesignationDto> getAllDesignations() {
        try {
            return Designation.mapList(ImmutableList.copyOf(designationRepository.findAll()), DesignationDto.class);
        }catch (Exception e){
            log.error("something went wrong in getAllDesignations() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public String deleteDesignation(Long designationId) {
        try {
            Designation designation=designationRepository.findById(designationId).orElse(null);
            if(designation==null)
                throw new NoSuchRecordFoundException("NO DESIGNATION PRESENT WITH ID = "+designationId);
            designationRepository.deleteById(designationId);
        } catch (NoSuchRecordFoundException e){
            log.error("NO DESIGNATION PRESENT WITH ID =  ",designationId);
            throw  e;
        }
        catch (Exception e){
            log.error("something went wrong in deleteDesignation() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
        return "Success";
    }
}
