package com.dig.leavemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveTypeDto {

    private Long leaveTypeId;

    private String name;

    private String description;

    private String noOfDaysAllowed;
}
