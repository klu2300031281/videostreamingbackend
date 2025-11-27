package com.streamflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    @Autowired
    private UserRepository repo;

    // 🔹 LOGIN API
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User u = repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return (u != null) ? "success" : "invalid";
    }

    // 🔹 SIGNUP API (CORRECTED)
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        try {
            repo.save(user);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
