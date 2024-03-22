package dev.rominaruiz.abocados.register;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.Facade.encryptations.EncoderFacade;
import dev.rominaruiz.abocados.roles.Role;
import dev.rominaruiz.abocados.roles.RoleService;
import dev.rominaruiz.abocados.users.User;
import dev.rominaruiz.abocados.users.UserRepository;

@Service
public class RegisterService {

    UserRepository userRepository;
    RoleService roleService;
    EncoderFacade encoder;

    public RegisterService(UserRepository userRepository, RoleService roleService, EncoderFacade encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    public String save(User newUser) {

        String password = newUser.getPassword();
        String hashedPassword = encoder.encode("bcrypt", password);
        
        newUser.setPassword(hashedPassword);
        assignDefaultRole(newUser);

        userRepository.save(newUser);

        return "user stored successfully :" + newUser.getUsername();

    }

    public void assignDefaultRole(User user) {

        Role defaultRole = roleService.getById(1L);
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        user.setRoles(roles);
    }
}