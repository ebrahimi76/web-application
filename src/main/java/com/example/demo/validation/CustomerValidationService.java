package com.example.demo.validation;

import com.example.demo.entity.users.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerValidationService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean valid(Customer customer) {
        return checkFirstname(customer) &&
                checkLastname(customer) &&
                checkUsername(customer) &&
                checkPassword(customer) &&
                checkEmail(customer);
    }

    private boolean checkFirstname(Customer customer) {
        boolean check = true;
        if (customer.getFirstname() != null) {
            check = customer.getFirstname().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        }
        return check;
    }

    private boolean checkLastname(Customer customer) {
        boolean check = true;
        if (customer.getLastname() != null) {
            check = customer.getLastname().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        }
        return check;
    }

    private boolean checkEmail(Customer customer) {
        boolean check = true;
        if (customer.getEmail() != null) {
            check = customer.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        }
        return check;
    }

    private boolean checkUsername(Customer customer) {
        boolean check = true;
        if (customer.getUsername() != null) {
            check = customer.getUsername().matches("^[a-zA-Z0-9._-]{3,}$");
        }
        return check;
    }

    private boolean checkPassword(Customer customer) {
        boolean check = true;
        if (customer.getPassword() != null) {
            check = customer.getPassword().matches("^[a-zA-Z0-9._-]{3,}$");
        }
        return check;
    }

}
