package ga.goanywhere.controllers;

import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.model.ProfileManager;
import ga.goanywhere.model.ProfileManagerImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
public class AccountController {
    private ProfileManager profileManager = new ProfileManagerImpl();

    @GetMapping("/user")
    public @ResponseBody UserEntity info(@RequestParam Long id){
        return profileManager.getInfo(id);
    }

    @PostMapping("/user")
    public @ResponseBody Id changeInfo(@RequestBody UserEntity userEntity) {
        profileManager.updateUserInfo(userEntity.getId(), userEntity);
        return new Id(userEntity.getId());
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Id {
        private Long Id;
    }
}
