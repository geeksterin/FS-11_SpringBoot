package com.geekster.DoctorAppointmentBookingApp.service;


import com.geekster.DoctorAppointmentBookingApp.model.BloopGroup;
import com.geekster.DoctorAppointmentBookingApp.model.Doctor;
import com.geekster.DoctorAppointmentBookingApp.model.Patient;
import com.geekster.DoctorAppointmentBookingApp.model.PatientAuthenticationToken;
import com.geekster.DoctorAppointmentBookingApp.model.dto.AuthenticationInputDto;
import com.geekster.DoctorAppointmentBookingApp.model.dto.SignInInputDto;
import com.geekster.DoctorAppointmentBookingApp.repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepo patientRepo;


    @Autowired
    PTokenService pTokenService;

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

    public String patientSignIn(SignInInputDto signInInput) {

        //check if the email is there in your tables
        //sign in only possible if this person ever signed up

        String email = signInInput.getEmail();

        Patient existingPatient = patientRepo.findFirstByPatientEmail(email);

        if(existingPatient == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        String password = signInInput.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if(existingPatient.getPatientPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                PatientAuthenticationToken token  = new PatientAuthenticationToken(existingPatient);

                if(EmailService.sendEmail(email,"otp after login", token.getTokenValue())) {
                    pTokenService.createToken(token);
                    return "check email for otp/token!!!";
                }
                else {
                    return "error while generating token!!!";
                }

            }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    public String patientSignOut(AuthenticationInputDto authInfo) {

        if(pTokenService.authenticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            pTokenService.deleteToken(tokenValue);
            return "Sign Out successful!!";
        }
        else {
            return "Un Authenticated access!!!";
        }

    }

    public List<Patient> getAllPatients() {

        return patientRepo.findAll();
    }

    public List<Patient> getAllPatientsByBloodGroup(BloopGroup bloodGroup) {

        List<Patient> patients = patientRepo.findByPatientBloodGroup(bloodGroup);

        for(Patient patient: patients)
        {
            patient.setAppointments(null);
        }

        return patients;
    }
}
