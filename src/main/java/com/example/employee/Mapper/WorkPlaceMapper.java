package com.example.employee.Mapper;

import com.example.employee.DTO.WorkPlaceCreateDTO;
import com.example.employee.DTO.WorkPlaceDTO;
import com.example.employee.Entity.EmployeeEntity;
import com.example.employee.Entity.WorkPlaceEntity;

public class WorkPlaceMapper implements DTOMapper<WorkPlaceEntity, WorkPlaceDTO>{

    @Override
    public WorkPlaceDTO getEntityToDTO(WorkPlaceEntity workPlace) {
        return new WorkPlaceDTO(
                workPlace.getIdEmployee(),
                workPlace.getSize()
        );
    }

    @Override
    public WorkPlaceEntity getDTOToEntity(WorkPlaceDTO workPlaceDTO) {
        new WorkPlaceEntity();
        return new WorkPlaceEntity(
                workPlaceDTO.getId(),
                workPlaceDTO.getSize()
        );
    }

    public WorkPlaceEntity getCreateDTOToEntity(WorkPlaceCreateDTO workPlaceCreateDTO){
        return new WorkPlaceEntity(
                workPlaceCreateDTO.getIdEmployee(),
                workPlaceCreateDTO.getSize()
        );
    }
}
