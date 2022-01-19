package com.example.demo.service;

import com.example.demo.config.AppConfig;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@SpringJUnitConfig({AppConfig.class})
public class EmployeeServiceTest {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomersOrderRepository customersOrderRepository;

    @Autowired
    private HomeServiceRepository homeServiceRepository;

    @Autowired
    private HomeServiceOptionRepository homeServiceOptionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testAddSuggestion_isOk() {
        Employee employee = Employee.builder()
                .password("")
                .balance(BigDecimal.valueOf(120))
                .email("")
                .firstname("reza")
                .username("reza1")
                .build();
        employeeService.save(employee);

        Customer user = Customer.builder()
                .firstname("Ali")
                .username("Ali1234")
                .password("lskjdklfj")
                .build();
        customerService.save(user);

        HomeService homeService = HomeService.builder()
                .name("cleaning")
                .build();

        HomeServiceOption homeServiceOption = HomeServiceOption.builder()
                .homeService(homeService)
                .basePrice(BigDecimal.valueOf(12_000))
                .description("washing ...")
                .build();

        homeService.getSubServices().add(homeServiceOption);
        homeServiceRepository.save(homeService);
        homeServiceOptionRepository.save(homeServiceOption);

        CustomersOrder order = CustomersOrder.builder()
                .customer(user)
                .service(homeServiceOption)
                .build();
        customersOrderRepository.save(order);
        customerService.addOrder(user, order);

        Suggestion suggestion = Suggestion.builder()
                .employee(employee)
                .order(order)
                .description("cjfjfbhjnkm")
                .build();

        employeeService.addSuggest(employee, suggestion);
        employeeService.save(employee);

        List<Suggestion> suggestions = customerRepository
                .findById(user.getId())
                .orElse(new Customer())
                .getOrders()
                .get(0)
                .getSuggestions();

        assertEquals(suggestion, suggestions.get(0));
    }
}
