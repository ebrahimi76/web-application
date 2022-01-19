package com.example.demo.repository;

import com.example.demo.entity.users.Admin;
import com.example.demo.repository.core.BaseRepository;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin> {
    Optional<Admin> findById(Long id);
    Optional<Admin> findByUsernameAndPassword(String username,String password);
    //Page<Admin> findAll(Pageable pageable);
}
