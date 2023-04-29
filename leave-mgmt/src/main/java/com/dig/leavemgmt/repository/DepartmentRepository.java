package com.dig.leavemgmt.repository;

import com.dig.leavemgmt.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
