package ga.goanywhere.controllers;

import ga.goanywhere.model.RegistrationManager;
import ga.goanywhere.model.RegistrationManagerImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;


@Controller
public class RegisterController {
    private RegistrationManager registrationManager = new RegistrationManagerImpl();


    @PostMapping("/register")
    public @ResponseBody Id register(@RequestBody UserRegistration user)
            throws NoSuchAlgorithmException {
        return new Id(registrationManager.createUser(user.getUsername(),
                user.getPassword(), user.getEmail(), user.getFirstName(),
                user.getLastName(), user.getSex()));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class UserRegistration {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String sex;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Id {
        private Long id;
    }
}
