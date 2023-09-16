package com.geekster.UserManagement.repo;

import com.geekster.UserManagement.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserFactory {

    @Bean
    List<User> getUserListInit()
    {
        return new ArrayList<>();
    }
}
