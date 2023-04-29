package com.dig.leavemgmt.entity;

import com.dig.leavemgmt.model.EmployeeDto;
import com.dig.leavemgmt.model.TestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_code")
   // @Type(type = "uuid-char")
    private UUID employeeCode=UUID.randomUUID();

    @Column(name = "name")
    private String name;

    public static TestDto toDto(TestProjection testProjection){
        return  new ModelMapper().map(testProjection,TestDto.class);
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> new ModelMapper().map(element, targetClass))
                .collect(Collectors.toList());
    }
}
