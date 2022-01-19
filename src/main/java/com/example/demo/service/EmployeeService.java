package com.example.demo.service;


import com.example.demo.entity.option.CustomersOrder;
import com.example.demo.entity.option.Suggestion;
import com.example.demo.entity.users.Customer;
import com.example.demo.entity.users.Employee;
import com.example.demo.repository.CustomersOrderRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.core.BaseService;
import com.example.demo.validation.EmployeeValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService extends BaseService<Employee, Long> {

    private final EmployeeRepository repository;
    private final EmployeeValidationService employeeValidationService;
    private final CustomersOrderRepository customersOrderRepository;

    @PostConstruct
    public void init() {
        setJpaRepository(repository);
    }


    @Override
    @Transactional
    public void save(Employee entity) {
        super.save(entity);
    }

    @Override
    @Transactional
    public void update(Employee entity) {
        if (employeeValidationService.valid(entity)) {
            super.update(entity);
        }
    }

    @Override
    @Transactional
    public void delete(Employee entity) {
        if (employeeValidationService.valid(entity)) {
            super.delete(entity);
        }
    }


    @Transactional
    public Optional<Employee> loadById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public List<Employee> loadAll() {
        return super.loadAll();
    }

    @Transactional
    public void addSuggest(Employee employee, Suggestion suggestion) {
        employee.getSuggestions().add(suggestion);
        CustomersOrder order = suggestion.getOrder();
        order.getSuggestions().add(suggestion);
        super.save(employee);
        customersOrderRepository.save(order);
    }
}

