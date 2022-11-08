package com.example.employee.Mapper;

import com.example.employee.DTO.EmployeeCreateDTO;
import com.example.employee.DTO.EmployeeDTO;
import com.example.employee.Entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDTO getEntityToDTO(EmployeeEntity employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getLogin(),
                employee.getEmail()
        );
    }

    public static EmployeeEntity getDTOToEntity(EmployeeDTO employeeDTO) {
        return new EmployeeEntity(
                employeeDTO.getName(),
                employeeDTO.getLogin(),
                null,
                employeeDTO.getEmail()
        );
    }

    public static EmployeeEntity getCreateDTOToEntity(EmployeeCreateDTO employeeCreateDTO){
        return new EmployeeEntity(
                employeeCreateDTO.getName(),
                employeeCreateDTO.getLogin(),
                employeeCreateDTO.getPassword(),
                employeeCreateDTO.getEmail()
        );
    }

}
