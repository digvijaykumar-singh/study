package com.dig.leavemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonDto {

    private String createdBy;
    private Date creationDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
}
