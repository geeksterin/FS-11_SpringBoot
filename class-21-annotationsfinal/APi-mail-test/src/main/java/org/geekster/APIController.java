package org.geekster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping("name")
    public Car getName()
    {

        //String value = "Shravan";
        Car c1 = new Car("golden");
        MailHandlerBase.sendMail(c1.toString());
        return c1;
    }



}
