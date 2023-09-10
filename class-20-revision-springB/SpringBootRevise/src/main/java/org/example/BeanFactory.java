package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanFactory {

    @Bean
    //@Primary
    public Cat getCat1()
    {
        return new Cat("Orange");
    }


    //@Bean
    public Cat getCat2()
    {
        return new Cat("Black");
    }

    @Bean
    public List<Integer> getEmptyList()
    {
        return new ArrayList<>();
    }
}
