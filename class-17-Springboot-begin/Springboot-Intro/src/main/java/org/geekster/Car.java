package org.geekster;


import org.springframework.stereotype.Component;

@Component
public class Car {

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public Car() {
        this.color = "Golden";
        System.out.println("Car Object created!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public String getColor() {
        return color;
    }
}
