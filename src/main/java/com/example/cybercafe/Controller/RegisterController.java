package com.example.cybercafe.Controller;

import com.example.cybercafe.Model.RegistrationModel;
import com.example.cybercafe.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class RegisterController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public RegistrationModel registration(@RequestBody RegistrationModel registration){

        return registrationService.RegisterUser(registration);
    }

    @PutMapping("/uploadimage/{email}")
    public Map<String, String> uploadFileimage(@RequestParam("file") MultipartFile file,
                                               @PathVariable("email") String email) throws IOException{
        Map<String,String > response = new HashMap<>();
        try {

           return registrationService.uploadimage(file,email);

        } catch (Exception e) {
            response.put("status","Failure");
            return response;
        }
    }

    @PutMapping("/uploadId/{email}")
    public Map<String,String> uploadFileId(@RequestParam("file") MultipartFile file,
                                                      @PathVariable("email") String email) throws IOException{
        Map<String,String > response = new HashMap<>();
        try {
            return registrationService.uploadId(file,email);

        } catch (Exception e) {
            response.put("status","Failure");
            return response;
        }
    }

    @GetMapping("/getDetails/{id}")
    public Optional<RegistrationModel> registrationModel(@PathVariable("id") int id){
        return registrationService.GetAllDetails(id);
    }


}
