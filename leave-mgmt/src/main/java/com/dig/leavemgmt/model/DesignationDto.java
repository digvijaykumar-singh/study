package com.dig.leavemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationDto {
    private Long designationId;
    private String name;
    private String description;
}
