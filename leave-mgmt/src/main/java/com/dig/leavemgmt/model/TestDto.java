package com.dig.leavemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private Long employeeId;

    private UUID employeeCode;

    private String name;
}
