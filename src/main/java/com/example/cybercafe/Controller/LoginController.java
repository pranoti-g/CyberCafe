package com.example.cybercafe.Controller;

import com.example.cybercafe.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> userInput) {
        return loginService.login(userInput);
    }

    @GetMapping("/validateuser/{username}")
    public Map<String,String> user(@PathVariable("username") String username){
        return loginService.user(username);
    }
}
