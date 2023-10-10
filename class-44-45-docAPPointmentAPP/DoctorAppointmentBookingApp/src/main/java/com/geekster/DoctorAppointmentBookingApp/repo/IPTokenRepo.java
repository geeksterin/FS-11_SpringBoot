package com.geekster.DoctorAppointmentBookingApp.repo;

import com.geekster.DoctorAppointmentBookingApp.model.PatientAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTokenRepo extends JpaRepository<PatientAuthenticationToken,Integer> {
    PatientAuthenticationToken findFirstByTokenValue(String tokenValue);
}
