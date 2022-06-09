package com.example.cybercafe.Repository;

import com.example.cybercafe.Model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<RegistrationModel , Integer> {

    RegistrationModel findByEmail(String email);

    RegistrationModel findByUsername(String username);
}
