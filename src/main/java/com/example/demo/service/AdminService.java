package com.example.demo.service;

import com.example.demo.entity.option.CustomersOrder;
import com.example.demo.entity.option.OrderStatus;
import com.example.demo.entity.option.Suggestion;
import com.example.demo.entity.users.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.core.BaseService;
import com.example.demo.validation.CustomerValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService extends BaseService<Customer, Long> {


}

