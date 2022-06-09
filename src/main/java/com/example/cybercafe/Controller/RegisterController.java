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
    public String uploadFileimage(@RequestParam("file") MultipartFile file,
                                  @PathVariable("email") String email) throws IOException{
        Map<String,String > response = new HashMap<>();
        try {

            registrationService.uploadimage(file,email);
            return response.put("status","Success");

        } catch (Exception e) {
            return response.put("status","Failure");
        }
    }

    @PutMapping("/uploadId/{email}")
    public ResponseEntity<HttpStatus> uploadFileId(@RequestParam("file") MultipartFile file,
                                                      @PathVariable("email") String email) throws IOException{

        try {
            registrationService.uploadId(file,email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDetails/{id}")
    public Optional<RegistrationModel> registrationModel(@PathVariable("id") int id){
        return registrationService.GetAllDetails(id);
    }


}
