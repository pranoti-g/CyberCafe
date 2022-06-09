package com.example.cybercafe.Service;

import com.example.cybercafe.Model.RegistrationModel;
import com.example.cybercafe.Repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
public class RegistrationService {

    @Autowired
    RegisterRepo registerRepo;

    public RegistrationModel RegisterUser(RegistrationModel registrationModel) {

        return registerRepo.save(registrationModel);
    }

    public RegistrationModel uploadimage(MultipartFile file, String email) throws IOException {
       RegistrationModel registrationModel= registerRepo.findByEmail(email);

        try {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            registrationModel.setPhotofilename(filename);
            registrationModel.setPhotodata(file.getBytes());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return registerRepo.save(registrationModel);
    }

    public Optional<RegistrationModel> GetAllDetails(int id) {

        return registerRepo.findById(id);
    }
}
