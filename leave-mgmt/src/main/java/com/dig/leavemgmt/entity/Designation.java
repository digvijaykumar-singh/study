package com.dig.leavemgmt.entity;

import com.dig.leavemgmt.model.DesignationDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="designation_tbl")
@Data
public class Designation extends Auditable<String>{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "designation_id")
    private Long designationId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    public static DesignationDto toDto(Designation designation){
        return  new ModelMapper().map(designation,DesignationDto.class);
    }

    public static Designation toEntity(DesignationDto designationDto){
        return  new ModelMapper().map(designationDto,Designation.class);
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> new ModelMapper().map(element, targetClass))
                .collect(Collectors.toList());
    }
}
