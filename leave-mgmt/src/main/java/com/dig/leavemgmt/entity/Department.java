package com.dig.leavemgmt.entity;

import com.dig.leavemgmt.model.DepartmentDto;
import com.dig.leavemgmt.model.EmployeeDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "department_tbl")
@Data
public class Department  extends Auditable<String>{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public static DepartmentDto toDto(Department employee){
        return  new ModelMapper().map(employee,DepartmentDto.class);
    }

    public static Department toEntity(DepartmentDto employee){
        return  new ModelMapper().map(employee,Department.class);
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> new ModelMapper().map(element, targetClass))
                .collect(Collectors.toList());
    }
}
