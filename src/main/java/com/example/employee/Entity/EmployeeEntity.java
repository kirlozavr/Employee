package com.example.employee.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
public class EmployeeEntity {

    @Id
    @SequenceGenerator(
            name = "employee_id_seq",
            sequenceName = "employee_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_seq"
    )

    private Long id;
    private String name, login, password, email;

    public EmployeeEntity(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public EmployeeEntity() {

    }

}
