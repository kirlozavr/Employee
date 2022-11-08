package com.example.employee.Service;

import com.example.employee.Entity.WorkPlaceEntity;
import com.example.employee.Repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class WorkPlaceService {

    private final WorkPlaceRepository workPlaceRepository;

    @Autowired
    public WorkPlaceService(WorkPlaceRepository workPlaceRepository) {
        this.workPlaceRepository = workPlaceRepository;
    }

    public Iterable<WorkPlaceEntity> getAllWorkPlace() {
        return workPlaceRepository.findAll();
    }

    public Optional<WorkPlaceEntity> getWorkPlaceById(Long idEmployee) {
        return workPlaceRepository.findById(idEmployee);
    }

    public Optional<WorkPlaceEntity> getWorkPlaceByLoginEmployee(Long idEmployee){
        return workPlaceRepository.findWorkPlaceEntityByIdEmployee(idEmployee);
    }

    public void setNewWorkPlace(WorkPlaceEntity workPlace) {
        Optional<WorkPlaceEntity> workPlaceOptional = workPlaceRepository
                .findWorkPlaceEntityByIdEmployee(workPlace.getIdEmployee());
        if (workPlaceOptional.isPresent()) {
            throw new IllegalStateException("This user exists");
        }
        workPlaceRepository.save(workPlace);
    }

    @Transactional
    public void updateWorkPlace(Long workPlaceId,
                                Long idEmployee,
                                Integer size) {
        WorkPlaceEntity workPlace = workPlaceRepository
                .findById(workPlaceId)
                .orElseThrow(() -> new IllegalStateException("Work Place does not exists"));
        if (idEmployee != null &&
                idEmployee > 0 &&
                !Objects.equals(workPlace.getIdEmployee(), idEmployee)) {
            workPlace.setIdEmployee(idEmployee);
        }
        if (size != null &&
                size > 0 &&
                !Objects.equals(workPlace.getSize(), size)) {
            workPlace.setSize(size);
        }
    }

    public  void deleteWorkPlace(Long workPlaceId){
        boolean exists = workPlaceRepository.existsById(workPlaceId);
        if(!exists){
            throw new IllegalStateException("Work Place does not exists");
        }
        workPlaceRepository.deleteById(workPlaceId);
    }

}
