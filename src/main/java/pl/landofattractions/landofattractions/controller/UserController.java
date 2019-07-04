package pl.landofattractions.landofattractions.controller;

import org.springframework.web.bind.annotation.*;
import pl.landofattractions.landofattractions.model.User;
import pl.landofattractions.landofattractions.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/users/del/{id}")
    void delUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/users/{id}")
    User getUser(@PathVariable long id) {
        return userRepository.findById(id);
    }
}
