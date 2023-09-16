package com.geekster.UserManagement.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private Integer userId;

    @NotBlank
    private String userName;


    @Email
    private String userEmail;

    @Size(min=8)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",message = "password is not strong !!!!")
    private String password;

    @Size(min=10,max=10)
    @Pattern(regexp = "^[0-9]+$", message = "contacts should be just numbers!!")
    private String userContact;

   // @Min(18)
   // private Integer userAge;

    private Gender userGender;

    private Type userType;

    private LocalDateTime userDOB;


}
