package com.example.cybercafe.Controller;

import com.example.cybercafe.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")

    public Map<String, String> login(@RequestBody Map<String, String> userInput) {
        return loginService.login(userInput);
    }
}
