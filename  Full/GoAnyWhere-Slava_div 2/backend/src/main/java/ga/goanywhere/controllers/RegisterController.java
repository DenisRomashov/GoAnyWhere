package ga.goanywhere.controllers;

import ga.goanywhere.entities.UserEntity;
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

import java.math.BigInteger;


@Controller
public class RegisterController {
    private RegistrationManager registrationManager = new RegistrationManagerImpl();


    @PostMapping("/register")
    public @ResponseBody BigInteger register(@RequestBody UserRegistration user){
        if (user.getEmail()!= null) {
            return registrationManager.createUser(user.getUsername(),
                    user.getPassword(), user.getEmail());
        } else {
            return registrationManager.createUser(user.getUsername(),
                    user.getPassword());
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class UserRegistration {
        private String username;
        private String password;
        private String email;

        public UserRegistration(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
