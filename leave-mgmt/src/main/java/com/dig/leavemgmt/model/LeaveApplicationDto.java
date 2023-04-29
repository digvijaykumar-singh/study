package com.dig.leavemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveApplicationDto {

    private Long applicationId;

    private String referenceNo;

    private EmployeeDto employee;

    private LeaveTypeDto leaveType;

    private int noOfDays;

    private Date fromDate;

    private Date toDate;

    private String leaveStatus;

    private String remarks;

    private Date approvalDate;

    private String approvedBy;
}
