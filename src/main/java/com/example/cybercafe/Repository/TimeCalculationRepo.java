package com.example.cybercafe.Repository;

import com.example.cybercafe.Model.TimeCalculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeCalculationRepo extends JpaRepository<TimeCalculation,Integer> {
}
