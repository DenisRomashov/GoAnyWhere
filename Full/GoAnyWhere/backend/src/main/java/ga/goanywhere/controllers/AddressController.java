package ga.goanywhere.controllers;

import ga.goanywhere.entities.AddressEntity;
import ga.goanywhere.model.AddressManager;
import ga.goanywhere.model.AddressManagerImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AddressController {
    private AddressManager addressManager = new AddressManagerImpl();

    @PostMapping("/address")
    public @ResponseBody Id getId(@RequestBody AddressEntity address){
        return new Id(addressManager.getOrCreateAddress(address));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Id {
        private Long id;
    }
}
