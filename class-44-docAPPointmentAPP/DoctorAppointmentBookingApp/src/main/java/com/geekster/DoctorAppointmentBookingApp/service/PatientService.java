package com.geekster.DoctorAppointmentBookingApp.service;


import com.geekster.DoctorAppointmentBookingApp.model.Patient;
import com.geekster.DoctorAppointmentBookingApp.repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class PatientService {

    @Autowired
    IPatientRepo patientRepo;

    public String patientSignUp(Patient patient) {

        //check if already exist -> Not allowed : try logging in

        String newEmail = patient.getPatientEmail();

        Patient existingPatient = patientRepo.findFirstByPatientEmail(newEmail);

        if(existingPatient != null)
        {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = patient.getPatientPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            patient.setPatientPassword(encryptedPassword);


            // patient table - save patient
            patientRepo.save(patient);
            return "patient registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }
}
