package com.example.employee.Controller;

import com.example.employee.DTO.EmployeeCreateDTO;
import com.example.employee.DTO.EmployeeDTO;
import com.example.employee.Entity.EmployeeEntity;
import com.example.employee.Mapper.EmployeeMapper;
import com.example.employee.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController implements CRUDController<EmployeeDTO, Long, EmployeeCreateDTO> {

    private final EmployeeService employeeService;

    @Override
    @GetMapping("/")
    public List<EmployeeDTO> getAllEntity() {
        return StreamSupport
                .stream(employeeService.getAllEmployee().spliterator(), false)
                .map(EmployeeMapper::getEntityToDTO)
                .toList();
    }

    @Override
    @GetMapping(path = "/id={employeeId}")
    public EmployeeDTO getFindById(@PathVariable("employeeId") Long employeeId) {
        return EmployeeMapper.getEntityToDTO(employeeService.getEmployee(employeeId));
    }

    @GetMapping(path = "/login={employeeLogin}")
    public EmployeeDTO getFindByLogin(@PathVariable("employeeLogin") String employeeLogin) {
        return EmployeeMapper.getEntityToDTO(employeeService.getEmployee(employeeLogin));
    }

    @Override
    @PostMapping
    public void postEntity(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
        employeeService.setNewEmployee(EmployeeMapper.getCreateDTOToEntity(employeeCreateDTO));
    }

    @Override
    @PutMapping(path = "/{employeeId}")
    public void putEntity(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody EmployeeCreateDTO employeeCreateDTO) {

        EmployeeEntity employeeEntity = employeeService.getEmployee(employeeId);

        if (employeeCreateDTO.getName() != null &&
                employeeCreateDTO.getName().length() > 0 &&
                !Objects.equals(employeeEntity.getName(), employeeCreateDTO.getName())) {
            employeeEntity.setName(employeeCreateDTO.getName());
        }
        if (employeeCreateDTO.getLogin() != null &&
                employeeCreateDTO.getLogin().length() > 0 &&
                !Objects.equals(employeeEntity.getLogin(), employeeCreateDTO.getLogin())) {
            employeeEntity.setLogin(employeeCreateDTO.getLogin());
        }
        if (employeeCreateDTO.getPassword() != null &&
                employeeCreateDTO.getPassword().length() > 0 &&
                !Objects.equals(employeeEntity.getPassword(), employeeCreateDTO.getPassword())) {
            employeeEntity.setPassword(employeeCreateDTO.getPassword());
        }
        if (employeeCreateDTO.getEmail() != null &&
                employeeCreateDTO.getEmail().length() > 0 &&
                !Objects.equals(employeeEntity.getEmail(), employeeCreateDTO.getEmail())) {
            employeeEntity.setEmail(employeeCreateDTO.getEmail());
        }
        employeeService.updateEmployee(employeeEntity);
    }

    @Override
    @DeleteMapping(path = "/{employeeId}")
    public void deleteEntity(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
