package com.dig.leavemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long employeeId;

    private String name;

    private Long manager;

    private String employeeCode;

    private String email;

    private String gender;

    private String mobileNumber;

    private AddressDto address;
    private DesignationDto designation;
    private DepartmentDto department;
    private int status;
}
