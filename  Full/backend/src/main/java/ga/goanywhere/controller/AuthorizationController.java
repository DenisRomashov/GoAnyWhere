package ga.goanywhere.controller;

import ga.goanywhere.dao.UserEntity;
import ga.goanywhere.model.AuthorizationManager;
import ga.goanywhere.model.AuthorizationManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorizationController {
    private AuthorizationManager authorizationManager = new AuthorizationManagerImpl();

    @PostMapping("/auth")
    public @ResponseBody Long authorize(@RequestBody UserEntity user){
        return authorizationManager.logIn(user.getUsername(), user.getPassword());
    }
}
