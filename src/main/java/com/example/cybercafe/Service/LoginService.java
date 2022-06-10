package com.example.cybercafe.Service;

import com.example.cybercafe.Model.RegistrationModel;
import com.example.cybercafe.Repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    RegisterRepo registerRepo;

    public Map<String, String> login(Map<String, String> userInput) {
        String username = (String) userInput.get("username");
        String password = userInput.get("password");
        Map<String, String> response = new HashMap<String, String>();
        try {
            RegistrationModel registrationModel = registerRepo.findByUsername(username);
            if (registrationModel.getUsername().equals(username) && registrationModel.getPassword().equals(password)) {
                        response.put("status", "valid-user");
                        return response;
            }else {
                response.put("status", "Incorrect credentials");

            }
        } catch (Exception e) {
            response.put("status", "User doesn't exist");
            return response;
        }
        return response;
    }
}