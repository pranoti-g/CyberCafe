package com.example.cybercafe.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TimeCalculation")
public class TimeCalculation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String loginTime;
    private String logoutTime;
    private String timeUtilized;

    public TimeCalculation() {
    }
}
