package com.dig.leavemgmt.entity;

import com.dig.leavemgmt.model.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "employee_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Auditable<String> {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_code",unique=true,nullable = false)
    private String employeeCode;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name="mobile_number",nullable = false)
    private String mobileNumber;

    @OneToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "designation_id")
    private Designation designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @Column(name = "status",nullable = false)
    private int status;

    public static EmployeeDto toDto(Employee employee){
      return  new ModelMapper().map(employee,EmployeeDto.class);
    }

    public static Employee toEntity(EmployeeDto employee){
        return  new ModelMapper().map(employee,Employee.class);
    }

   public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> new ModelMapper().map(element, targetClass))
                .collect(Collectors.toList());
    }
}
