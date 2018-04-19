package ga.goanywhere.controllers;

import ga.goanywhere.model.AuthorizationManager;
import ga.goanywhere.model.AuthorizationManagerImpl;
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
public class AuthorizationController {
    private AuthorizationManager authorizationManager = new AuthorizationManagerImpl();

    @PostMapping("/auth")
    public @ResponseBody Id authorize(@RequestBody UserAuth user){
        return new Id(authorizationManager.logIn(user.getUsername(), user.getPassword()));
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class UserAuth{
        private String username;
        private String password;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Id {
        private BigInteger id;
    }
}
