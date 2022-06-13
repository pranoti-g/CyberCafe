package com.example.cybercafe.Controller;

import com.example.cybercafe.Model.TimeCalculation;
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

    @PostMapping("/saveLoginTime")
    public TimeCalculation saveLoginTime(@RequestBody TimeCalculation timeCalculation){
        return loginService.saveLoginTime(timeCalculation);
    }

    @PutMapping("/timeUtilized")
    public TimeCalculation timeUtilized(@RequestBody Map<String ,String> userDeatils){
        return loginService.timeUtilized(userDeatils);
    }
}
