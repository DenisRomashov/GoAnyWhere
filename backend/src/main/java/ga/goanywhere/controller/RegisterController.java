package ga.goanywhere.controller;

import ga.goanywhere.dao.UserEntity;
import ga.goanywhere.model.RegistrationManager;
import ga.goanywhere.model.RegistrationManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegisterController {
    private RegistrationManager registrationManager = new RegistrationManagerImpl();


    @PostMapping("/register")
    public @ResponseBody String register(@RequestBody UserEntity user){
        registrationManager.createUser(user.getUsername(),  user.getPassword());
        return "Done";
    }
}
