package org.example;

import org.springframework.stereotype.Component;

//@Component
public class Cat {

    private String color;

    public Cat() {
        System.out.println("meow meow!!!!!!!!!!!!!!!");
    }

    public Cat(String color) {
        System.out.println(color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
