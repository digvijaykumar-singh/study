package com.dig.leavemgmt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "leave_type_tbl")
@Data
public class LeaveType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "leave_type_id")
    private Long leaveTypeId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="noOfDaysAllowed")
    private String noOfDaysAllowed;

}
