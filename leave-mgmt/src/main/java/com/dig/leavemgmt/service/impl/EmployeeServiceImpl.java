package com.dig.leavemgmt.service.impl;

import com.dig.leavemgmt.constants.EmployeeConstants;
import com.dig.leavemgmt.entity.Employee;
import com.dig.leavemgmt.entity.Test;
import com.dig.leavemgmt.entity.TestProjection;
import com.dig.leavemgmt.exception.NoSuchRecordFoundException;
import com.dig.leavemgmt.exception.ServiceException;
import com.dig.leavemgmt.model.EmployeeDto;
import com.dig.leavemgmt.model.TestDto;
import com.dig.leavemgmt.repository.EmployeeRepository;
import com.dig.leavemgmt.repository.TestRepository;
import com.dig.leavemgmt.service.EmployeeService;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestRepository testRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        try {

            Employee employee=Employee.toEntity(employeeDto);
            if(employee.getMobileNumber()!=null){
                employee.setEmployeeCode(EmployeeConstants.EMP_CODE_PREFIX +employee.getMobileNumber());
            }
            employee.setStatus(1);
            return Employee.toDto(employeeRepository.save(employee));
        }catch (Exception e){
            log.error("exception occurred while creating employee ",e);
            throw new ServiceException(e.getMessage(),e);
        }
    }
    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        try {
            Employee employee=employeeRepository.findById(employeeDto.getEmployeeId()).orElse(null);
            if(employee==null)
                throw new NoSuchRecordFoundException("NO EMPLOYEE PRESENT WITH ID = "+employeeDto.getEmployeeId());
            //need to change here
            return Employee.toDto(employeeRepository.save(Employee.toEntity(employeeDto)));
        }
        catch (NoSuchRecordFoundException e){
            log.error("NO EMPLOYEE PRESENT WITH ID =  ",employeeDto.getEmployeeId());
            throw  e;
        }
        catch (Exception e){
            log.error("exception occurred in updateEmployee() ",e);
            throw new ServiceException(e.getMessage(),e);
        }
    }
    @Override
    public String deleteEmployee(Long employeeId) {
        try {
            Employee employee=employeeRepository.findById(employeeId).orElse(null);
            if(employee==null)
                throw new NoSuchRecordFoundException("NO EMPLOYEE PRESENT WITH ID = "+employeeId);
             employeeRepository.deleteById(employeeId);
        }
        catch (Exception e){
            log.error("something went wrong in deleteEmployee() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
        return "Success";
    }
    @Override
    public List<EmployeeDto> getAllEmployee(Integer pageNo,Integer pageSize,String sortBy){
        try {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            return Employee.mapList(ImmutableList.copyOf(employeeRepository.findAll(paging)),EmployeeDto.class);
        }catch (Exception e){
            log.error("something went wrong in getAllEmployee() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
    }
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        try {
            return Employee.toDto(employeeRepository.findById(employeeId).orElseThrow(
                    () -> new NoSuchRecordFoundException("NO EMPLOYEE PRESENT WITH ID = " + employeeId)));
        } catch (NoSuchRecordFoundException e){
            log.error("NO EMPLOYEE PRESENT WITH ID =  ",employeeId);
            throw  e;
        }
        catch (Exception e){
            log.error("something went wrong in getEmployeeById() ",e);
            throw  new ServiceException(e.getMessage(),e);
        }
    }
   public Test createTest(Test test){
       return testRepository.save(test);
    }
    public List<TestDto> getAllTest(){
        List<TestDto> testDtos=new ArrayList<>();
        List<TestProjection> resp=testRepository.getTestByName("Digvijay");
        resp.forEach(rec->{
            TestDto testDto=new TestDto();
            testDto.setName(rec.getName());
            ByteBuffer byteBuffer=ByteBuffer.wrap(rec.getEmployeeCode());
            testDto.setEmployeeCode(new UUID(byteBuffer.getLong(),byteBuffer.getLong()));
            testDtos.add(testDto);
        });
        return testDtos;
    }
}
