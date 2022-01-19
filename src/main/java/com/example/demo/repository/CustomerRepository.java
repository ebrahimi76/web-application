package com.example.demo.repository;

import com.example.demo.entity.users.Admin;
import com.example.demo.entity.users.Customer;
import com.example.demo.repository.core.BaseRepository;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface CustomerRepository extends BaseRepository<Customer> {
    Optional<Customer> findById(Long id);
    Optional<Customer> findByUsernameAndPassword(String username,String password);
    //Page<Customer> findAll(Pageable pageable);
}
