package com.example.demo.validation;

import com.example.demo.entity.users.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeValidationService {
    @Transactional(propagation = Propagation.NESTED)
    public boolean valid(Employee employee) {
        /*return checkFirstname(employee) &&
                checkLastname(employee) &&
                checkUsername(employee) &&
                checkPassword(employee) &&
                checkEmail(employee);*/
        return true;
    }

    private boolean checkFirstname(Employee employee) {
        boolean check = true;
        if (employee.getFirstname() != null) {
            check = employee.getFirstname().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        }
        return check;
    }

    private boolean checkLastname(Employee employee) {
        boolean check = true;
        if (employee.getLastname() != null) {
            check = employee.getLastname().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        }
        return check;
    }

    private boolean checkEmail(Employee employee) {
        boolean check = true;
        if (employee.getEmail() != null) {
            check = employee.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        }
        return check;
    }

    private boolean checkUsername(Employee employee) {
        boolean check = true;
        if (employee.getUsername() != null) {
            check = employee.getUsername().matches("^[a-zA-Z0-9._-]{3,}$");
        }
        return check;
    }

    private boolean checkPassword(Employee employee) {
        boolean check = true;
        if (employee.getPassword() != null) {
            check = employee.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        }
        return check;
    }
}
