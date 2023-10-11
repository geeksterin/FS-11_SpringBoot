package com.geekster.DoctorAppointmentBookingApp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Patient.class,property = "patientId")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String patientName;
    private String patientEmail;
    private String patientPassword;

    @Enumerated(value = EnumType.STRING)
    private Gender patientGender;

    @Enumerated(value = EnumType.STRING)
    private BloopGroup patientBloodGroup;

    private String patientContact;
    private LocalDateTime patientDateOFBirth;

    @OneToMany(mappedBy = "patient")
    List<Appointment> appointments;




}
