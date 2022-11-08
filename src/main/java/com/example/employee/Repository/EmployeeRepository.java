package com.example.employee.Repository;

import com.example.employee.Entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository
        extends CrudRepository<EmployeeEntity, Long> {

    //@Query("SELECT s FROM EmployeeEntity s WHERE s.login = ?1")
    Optional<EmployeeEntity> findEmployeeEntityByLogin(String login);
}
