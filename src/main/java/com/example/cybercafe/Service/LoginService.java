package com.example.cybercafe.Service;

import com.example.cybercafe.Model.RegistrationModel;
import com.example.cybercafe.Model.TimeCalculation;
import com.example.cybercafe.Repository.RegisterRepo;
import com.example.cybercafe.Repository.TimeCalculationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    RegisterRepo registerRepo;

    @Autowired
    TimeCalculationRepo timeCalculationRepo;

    public Map<String, String> login(Map<String, String> userInput) {
        String username = userInput.get("username");
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

    public TimeCalculation timeUtilized(Map<String ,String > userDetails) {
        TimeCalculation timeCalculation = timeCalculationRepo.findAll().stream()
                .filter(timeCalculation1 -> timeCalculation1.getUsername().equals(userDetails.get("username")))
                .max(Comparator.comparingInt(TimeCalculation::getId)).orElseThrow();
        timeCalculation.setLogoutTime(userDetails.get("logoutTime"));
        timeCalculation.setTimeUtilized(userDetails.get("timeUtilized"));
        return timeCalculationRepo.save(timeCalculation);

    }

    public TimeCalculation saveLoginTime(TimeCalculation timeCalculation) {
        return timeCalculationRepo.save(timeCalculation);
    }
}
