package com.dig.leavemgmt.entity;

import com.dig.leavemgmt.model.EmployeeDto;
import com.dig.leavemgmt.model.LeaveApplicationDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "leave_application_tbl")
public class LeaveApplication extends Auditable<String>{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @Column(name = "reference_no")
    private String referenceNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leave_type_id", referencedColumnName = "leave_type_id")
    private LeaveType leaveType;

    @Column(name = "no_of_days",nullable = false)
    private int noOfDays;

    @Column(name = "from_date",nullable = false)
    private Date fromDate;

    @Column(name = "to_date",nullable = false)
    private Date toDate;

    @Column(name = "leave_status",nullable = false)
    private String leaveStatus;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "approval_date")
    private Date approvalDate;

    @Column(name = "approved_by")
    private String approvedBy;

    public static LeaveApplicationDto toDto(LeaveApplication leaveApplication){
        return  new ModelMapper().map(leaveApplication,LeaveApplicationDto.class);
    }

    public static LeaveApplication toEntity(LeaveApplicationDto leaveApplicationDto){
        return  new ModelMapper().map(leaveApplicationDto,LeaveApplication.class);
    }


}
