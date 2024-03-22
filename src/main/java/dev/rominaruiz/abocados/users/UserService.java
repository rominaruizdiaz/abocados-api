package dev.rominaruiz.abocados.users;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll(){
        List<User> users = repository.findAll();

        return users;
    }
}