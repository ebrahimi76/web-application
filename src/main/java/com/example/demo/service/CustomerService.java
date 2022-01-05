package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomersOrder;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.core.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService extends BaseService<Customer, Long> {

    private final CustomerRepository repository;

    @PostConstruct
    public void init() {
        setJpaRepository(repository);
    }


    @Override
    @Transactional
    public void save(Customer entity) {

            super.save(entity);

    }

    @Override
    @Transactional
    public void update(Customer entity) {

            super.update(entity);

    }

    @Override
    @Transactional
    public void delete(Customer entity) {

            super.delete(entity);

    }


    @Transactional
    public Optional<Customer> loadById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public List<Customer> loadAll() {
        return super.loadAll();
    }

    @Transactional
    public void addOrder(Customer customer, CustomersOrder order) {
        customer.getOrders().add(order);
        super.save(customer);
    }
}

