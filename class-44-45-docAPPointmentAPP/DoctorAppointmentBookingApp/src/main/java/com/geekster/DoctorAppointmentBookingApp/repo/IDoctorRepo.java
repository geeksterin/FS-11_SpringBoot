package com.geekster.DoctorAppointmentBookingApp.repo;

import com.geekster.DoctorAppointmentBookingApp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor,Integer> {
}
