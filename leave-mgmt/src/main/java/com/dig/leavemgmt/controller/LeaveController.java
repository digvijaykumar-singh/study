package com.dig.leavemgmt.controller;

import com.dig.leavemgmt.entity.LeaveApplication;
import com.dig.leavemgmt.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("leave")
    public LeaveApplication applyLeave(@RequestBody LeaveApplication leaveDto){
        return leaveService.applyLeave(leaveDto);
    }
}
