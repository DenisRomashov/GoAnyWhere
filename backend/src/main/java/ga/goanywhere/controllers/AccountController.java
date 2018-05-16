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

import java.sql.Date;

@Controller
public class AccountController {
    private ProfileManager profileManager = new ProfileManagerImpl();

    @GetMapping("/user")
    public @ResponseBody UserEntity info(@RequestParam Long id){
        return profileManager.getInfo(id);
    }

    @PostMapping("/user")
    public @ResponseBody Id changeInfo(@RequestBody UserInfo userInfo) {
        profileManager.updateUserInfo(userInfo.getId(), userInfo.getAddressId(), userInfo.getEmail(),
                userInfo.getPhoneNumber(), userInfo.getFacebookReference(), userInfo.getTwitterReference(),
                userInfo.getVkReference(), userInfo.getBirthday(), userInfo.getFirstName(), userInfo.getLastName(),
                userInfo.getSex());
        return new Id(userInfo.getId());
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Id {
        private Long Id;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class UserInfo {
        private Long id;
        private Long addressId;
        private String email;
        private String phoneNumber;
        private String facebookReference;
        private String twitterReference;
        private String vkReference;
        private Date birthday;
        private String firstName;
        private String lastName;
        private String sex;
    }
}
