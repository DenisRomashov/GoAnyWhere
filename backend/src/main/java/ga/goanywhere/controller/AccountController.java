package ga.goanywhere.controller;

import ga.goanywhere.dao.UserEntity;
import ga.goanywhere.model.ProfileManager;
import ga.goanywhere.model.ProfileManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {
    private ProfileManager profileManager = new ProfileManagerImpl();

    @GetMapping("/user")
    public @ResponseBody UserEntity info(@RequestParam Long id){
        return profileManager.getInfo(id);
    }

    @PostMapping("/user")
    public @ResponseBody String changeInfo(@RequestBody UserEntity userEntity) {
        profileManager.updateUserInfo(userEntity.getId(), userEntity);
        return "Salo";
    }
}
