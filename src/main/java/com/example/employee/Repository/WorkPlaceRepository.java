package com.example.employee.Repository;

import com.example.employee.Entity.WorkPlaceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkPlaceRepository
        extends CrudRepository<WorkPlaceEntity, Long> {

    Optional<WorkPlaceEntity> findWorkPlaceEntityByIdEmployee(Long idEmployee);
}
