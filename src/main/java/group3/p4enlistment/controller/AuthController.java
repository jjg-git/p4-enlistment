package group3.p4enlistment.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import group3.p4enlistment.model.*;
import group3.p4enlistment.security.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import group3.p4enlistment.model.User;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JWTUtilities jwtUtil;
    
    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User existing = userRepo.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!existing.getPassword().equals(user.getPassword()))
            throw new RuntimeException("Invalid credentials");

        String token = jwtUtil.generateToken(user.getUsername());
        return Map.of("token", token);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

}

