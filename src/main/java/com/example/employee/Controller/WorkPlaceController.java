package com.example.employee.Controller;

import com.example.employee.Entity.WorkPlaceEntity;
import com.example.employee.Service.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/workplace")
public class WorkPlaceController {

    private final WorkPlaceService workPlaceService;

    @Autowired
    public WorkPlaceController(WorkPlaceService workPlaceService) {
        this.workPlaceService = workPlaceService;
    }

    @GetMapping("/")
    public Iterable<WorkPlaceEntity> getAllEntity() {
        return workPlaceService.getAllWorkPlace();
    }

    @GetMapping("/id={workPlaceId}")
    public Optional<WorkPlaceEntity> getFindById(@PathVariable("workPlaceId") Long workPlaceId) {
        return workPlaceService.getWorkPlaceById(workPlaceId);
    }

    @GetMapping("/login={workPlaceLogin}")
    public Optional<WorkPlaceEntity> getFindByLogin(@PathVariable("workPlaceLogin") Long idEmployee) {
        return workPlaceService.getWorkPlaceByLoginEmployee(idEmployee);
    }

    @PostMapping
    public void postEntity(@RequestBody WorkPlaceEntity workPlace) {
        workPlaceService.setNewWorkPlace(workPlace);
    }

    @PutMapping("/{workPlaceId}")
    public void putEntity(
            @PathVariable("workPlaceId") Long workPlaceId,
            @RequestParam(required = false) Long idEmployee,
            @RequestParam(required = false) Integer size) {
        workPlaceService.updateWorkPlace(
                workPlaceId,
                idEmployee,
                size
        );
    }

    @DeleteMapping("/{workPlaceId}")
    public void deleteEntity(@PathVariable("workPlaceId") Long workPlaceId) {
        workPlaceService.deleteWorkPlace(workPlaceId);
    }
}
