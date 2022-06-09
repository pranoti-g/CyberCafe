package com.example.cybercafe.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "RegistrationDetails")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String photofilename;
    private String photofiletype;
    @Lob
    private byte[] photodata;
//    private String IDfilename;
//    private String IDfiletype;
//    @Lob
//    private byte[] IDdata;

    public RegistrationModel(String name, String email, String username, String password, String photofilename, String photofiletype, byte[] photodata) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.photofilename = photofilename;
        this.photofiletype = photofiletype;
        this.photodata = photodata;
    }

    public RegistrationModel() {
    }

}



