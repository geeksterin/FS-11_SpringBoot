package com.geekster.DoctorAppointmentBookingApp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInputDto {

    private String email;
    private String password;
}
