package org.geekster;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectFactory {

    public ObjectFactory() {
        System.out.println("configuration does create object as well!!!!");
    }

    @Bean
    @Primary
    public Car createBlueCar()
    {
        System.out.println("testing configuration class methods!!!!!!");
        return new Car("Blue");
    }

    @Bean
    public Car createOrangeCar()
    {
        System.out.println("testing configuration class methods!!!!!!");
        return new Car("Orange");
    }

    @Bean
    public Car createGreenCar()
    {
        System.out.println("testing configuration class methods!!!!!!");
        return new Car("Green");
    }
}
