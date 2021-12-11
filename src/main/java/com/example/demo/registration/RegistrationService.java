package com.example.demo.registration;

import com.example.demo.user.SystemUser;
import com.example.demo.user.SystemUserRole;
import com.example.demo.user.SystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    /*   */
    @Autowired
    private final SystemUserService systemUserService;
    /*  */
    @Autowired
    private final EmailValidator emailValidator;


    /* Method register new user to system  */
    public String register(RegistrationDTO request) {

        /* Check if Email is valid */
       /* boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail) {
            throw new IllegalStateException("email not valid");
        } */
        /* This method uses clientService to register new client */

        return systemUserService.signUpNewUser(
            new SystemUser(
                    request.getName(),
                    request.getUsername(),
                    request.getPassword(),
                    request.getEmail(),
                    SystemUserRole.USER
            )
        );

    }
}
