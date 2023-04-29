package com.dig.leavemgmt.repository;

import com.dig.leavemgmt.entity.Test;
import com.dig.leavemgmt.entity.TestProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository  extends CrudRepository<Test,Long> {

    @Query(value = "SELECT name as name ,employee_code as employeeCode FROM test",nativeQuery = true)
    public List<TestProjection> getTestByName(String name);
}
