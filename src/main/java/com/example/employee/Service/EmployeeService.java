package com.example.employee.Service;

import com.example.employee.DTO.EmployeeCreateDTO;
import com.example.employee.Entity.EmployeeEntity;
import com.example.employee.Exception.EmployeeNotFoundException;
import com.example.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Iterable<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("User does not exists"));
    }

    public EmployeeEntity getEmployee(String employeeLogin) {
        return employeeRepository.findEmployeeEntityByLogin(employeeLogin)
                .orElseThrow(() -> new EmployeeNotFoundException("User does not exists"));
    }

    public void setNewEmployee(EmployeeEntity employee) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository
                .findEmployeeEntityByLogin(employee.getLogin());
        if (employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("User exists");
        }
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new EmployeeNotFoundException("User does not exists");
        }
        employeeRepository.deleteById(employeeId);
    }
}
