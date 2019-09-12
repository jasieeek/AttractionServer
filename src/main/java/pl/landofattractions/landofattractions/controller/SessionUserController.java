package pl.landofattractions.landofattractions.controller;

import org.springframework.web.bind.annotation.*;

import pl.landofattractions.landofattractions.model.SessionUser;
import pl.landofattractions.landofattractions.repository.SessionUserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SessionUserController {
    private final SessionUserRepository sessionUserRepository;

    public SessionUserController(SessionUserRepository sessionUserRepository) {
        this.sessionUserRepository = sessionUserRepository;
    }

    @GetMapping("/session-user")
    public List<SessionUser> getSessions() {
        return (List<SessionUser>) sessionUserRepository.findAll();
    }

    @GetMapping("/session-user/{id}")
    public SessionUser getSessionUser(@PathVariable long id){
        return (SessionUser) sessionUserRepository.findFirstById(id);
    }

    @PostMapping("/session-user")
    void addSession(@RequestBody SessionUser sessionUser) {
        sessionUserRepository.save(sessionUser);
    }

    @PutMapping("/session-user/{id}")
    public SessionUser modifySession(@RequestBody SessionUser sessionUser, @PathVariable Long id) {
        return sessionUserRepository.findById(id)
                .map(session -> {
                    session.setStatus(sessionUser.isStatus());
                    session.setUser(sessionUser.getUser());
                    return sessionUserRepository.save(session);
                })
                .orElseGet(() -> {
                    System.out.println("Nie znaleziono poczatkowej sesji w bazie!");
                    return sessionUser;
                });
    }
}
