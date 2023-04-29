package com.dig.leavemgmt.service.impl;

import com.dig.leavemgmt.entity.Department;
import com.dig.leavemgmt.exception.NoSuchRecordFoundException;
import com.dig.leavemgmt.exception.ServiceException;
import com.dig.leavemgmt.model.DepartmentDto;
import com.dig.leavemgmt.repository.DepartmentRepository;
import com.dig.leavemgmt.service.DepartmentService;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class DepartmentServiceImpl  implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        try {
            return Department.toDto(departmentRepository.save(Department.toEntity(departmentDto)));
        }catch (Exception e){
            log.error("exception occurred while creating employee ",e);
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        try {
            Department department=departmentRepository.findById(departmentDto.getDepartmentId()).orElse(null);
            if(department==null)
                throw new NoSuchRecordFoundException("NO DEPARTMENT PRESENT WITH ID = "+departmentDto.getDepartmentId());
            //need to change here
            return Department.toDto(departmentRepository.save(Department.toEntity(departmentDto)));
        }
        catch (NoSuchRecordFoundException e){
            log.error("NO DEPARTMENT PRESENT WITH ID =  ",departmentDto.getDepartmentId());
            throw  e;
        }
        catch (Exception e){
            log.error("exception occurred in updateDepartment() ",e);
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        try {
            return Department.toDto(departmentRepository.findById(departmentId).orElseThrow(
                    () -> new NoSuchRecordFoundException("NO DEPARTMENT PRESENT WITH ID = " + departmentId)));
        } catch (NoSuchRecordFoundException e){
            log.error("NO EMPLOYEE PRESENT WITH ID =  ",departmentId);
            throw  e;
        }
        catch (Exception e){
            log.error("something went wrong in getDepartmentById() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        try {
            return Department.mapList(ImmutableList.copyOf(departmentRepository.findAll()), DepartmentDto.class);
        }catch (Exception e){
            log.error("something went wrong in getAllDepartments() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        try {
            Department department=departmentRepository.findById(departmentId).orElse(null);
            if(department==null)
                throw new NoSuchRecordFoundException("NO DEPARTMENT PRESENT WITH ID = "+departmentId);
            departmentRepository.deleteById(departmentId);
        } catch (NoSuchRecordFoundException e){
            log.error("NO DEPARTMENT PRESENT WITH ID =  ",departmentId);
            throw  e;
        }
        catch (Exception e){
            log.error("something went wrong in deleteDepartment() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
        return "Success";
    }
}
