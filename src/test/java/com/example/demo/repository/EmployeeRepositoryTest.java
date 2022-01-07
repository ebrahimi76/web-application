package com.example.demo.repository;


import com.example.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Test
    void testFindById_isOk() {
        Employee employee = Employee.builder()
                .password("")
                .balance(BigDecimal.valueOf(120))
                .email("")
                .firstname("reza")
                .username("reza1")
                .build();
        employeeRepository.save(employee);

        Optional<Employee> result = employeeRepository.findById(employee.getId());
        assertEquals(employee, result.orElse(new Employee()));
    }


}