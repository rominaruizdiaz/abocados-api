package dev.rominaruiz.abocados.register;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rominaruiz.abocados.users.User;

@RestController
@RequestMapping(path = "/api/v1/users/register")
public class RegisterController {
    
    RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping(path = "")
    public String register(@RequestBody User newUser){
        return service.save(newUser);
    
    }
}