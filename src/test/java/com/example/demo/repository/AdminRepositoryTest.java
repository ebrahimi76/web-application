package com.example.demo.repository;


import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminService adminService;
    @Test
    void testSave() {
        Admin ali = Admin.builder()
                .firstname("ali")
                .adminState(null)
                .build();
        adminService.save(ali);
        Optional<Admin> result = adminRepository.findById(ali.getId());
        assertEquals(ali.getFirstname(),result.orElse(new Admin()).getFirstname());
    }


}