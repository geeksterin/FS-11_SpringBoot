package com.geekster.InstaBackend.service;

import com.geekster.InstaBackend.model.AuthenticationToken;
import com.geekster.InstaBackend.model.User;
import com.geekster.InstaBackend.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;


}
