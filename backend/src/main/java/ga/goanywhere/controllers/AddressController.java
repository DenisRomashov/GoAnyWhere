package ga.goanywhere.controllers;

import ga.goanywhere.entities.AddressEntity;
import ga.goanywhere.model.AddressManager;
import ga.goanywhere.model.AddressManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressController {
    private AddressManager addressManager = new AddressManagerImpl();

    @PostMapping("/address")
    public @ResponseBody Long getId(@RequestBody AddressEntity address){
        return addressManager.createOrGetAddress(address);
    }
}
