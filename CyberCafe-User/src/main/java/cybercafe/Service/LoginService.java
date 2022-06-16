package cybercafe.Service;


import cybercafe.Model.RegistrationModel;
import cybercafe.Model.TimeCalculation;
import cybercafe.Model.UserLogoutResponse;
import cybercafe.Repository.RegisterRepo;
import cybercafe.Repository.TimeCalculationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    RegisterRepo registerRepo;

    @Autowired
    TimeCalculationRepo timeCalculationRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, String> login(Map<String, String> userInput) {
        String username = userInput.get("username");
        String password = userInput.get("password");
        Map<String, String> response = new HashMap<String, String>();
        try {
            RegistrationModel registrationModel = registerRepo.findByUsername(username);
            if(username.equals("admin")){
                if (registrationModel.getUsername().equals(username) && registrationModel.getPassword().equals(password)) {
                    response.put("status", "valid-admin");
                    return response;
                }
            }else if (registrationModel.getUsername().equals(username) && registrationModel.getPassword().equals(password)) {
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

    public TimeCalculation logout(Map<String ,String > userDetails) {
        TimeCalculation timeCalculation = timeCalculationRepo.findAll().stream()
                .filter(timeCalculation1 -> timeCalculation1.getUsername().equals(userDetails.get("username")))
                .max(Comparator.comparingInt(TimeCalculation::getId)).orElseThrow();
        String response = null;
        restTemplate.getForObject(
                "http://localhost:8082/userLogout/{username}",
                UserLogoutResponse.class,
                userDetails.get("username")
        );

        timeCalculation.setLogoutTime(userDetails.get("logoutTime"));
        timeCalculation.setTimeUtilized(userDetails.get("timeUtilized"));


        return timeCalculationRepo.save(timeCalculation);

    }

    public TimeCalculation saveLoginTime(TimeCalculation timeCalculation) {
        return timeCalculationRepo.save(timeCalculation);
    }
}
