package org.geekster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {


   //@Autowired
   Car carObj;

    @GetMapping("api/v1/dukhiAatmaa")
    public String api1()
    {

        return "Deepak";
    }

    @GetMapping("api/v1/car")
    public Car getCar()
    {

        return carObj;
    }

    @PutMapping("api/v1/change/color")
    public String setColor()
    {
        carObj.setColor("red");
        return "colour changed";
    }
}
