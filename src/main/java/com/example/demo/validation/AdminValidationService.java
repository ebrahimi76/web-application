package com.example.demo.validation;

import com.example.demo.entity.users.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminValidationService {
    @Transactional(propagation = Propagation.NESTED)
    public boolean valid(Admin admin) {
        return checkFirstname(admin) &&
                checkLastname(admin) &&
                checkUsername(admin) &&
                checkPassword(admin) &&
                checkEmail(admin);
    }

    private boolean checkFirstname(Admin admin) {
        boolean check = true;
        if (admin.getFirstname() != null) {
            check = admin.getFirstname().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        }
        return check;
    }

    private boolean checkLastname(Admin admin) {
        boolean check = true;
        if (admin.getLastname() != null) {
            check = admin.getLastname().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        }
        return check;
    }

    private boolean checkEmail(Admin admin) {
        boolean check = true;
        if (admin.getEmail() != null) {
            check = admin.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        }
        return check;
    }

    private boolean checkUsername(Admin admin) {
        boolean check = true;
        if (admin.getUsername() != null) {
            check = admin.getUsername().matches("^[a-zA-Z0-9._-]{3,}$");
        }
        return check;
    }

    private boolean checkPassword(Admin admin) {
        boolean check = true;
        if (admin.getPassword() != null) {
            check = admin.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        }
        return check;
    }
}
