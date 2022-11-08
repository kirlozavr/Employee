package com.example.employee.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
public class WorkPlaceEntity {

    @Id
    @SequenceGenerator(
            name = "work_place_sequence",
            sequenceName = "work_place_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "work_place_sequence"
    )
    private Long id;

    private Long idEmployee;
    private Integer size;

    public WorkPlaceEntity(Long idEmployee, Integer size) {
        this.idEmployee = idEmployee;
        this.size = size;
    }

    public WorkPlaceEntity() {}

}
