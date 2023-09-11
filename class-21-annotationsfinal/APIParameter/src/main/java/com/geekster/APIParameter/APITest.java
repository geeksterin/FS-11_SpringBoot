package com.geekster.APIParameter;


import org.springframework.web.bind.annotation.*;

@RestController
public class APITest {


    @GetMapping("name")
    public String getName()
    {
        return "Vishal";
    }

    //pass arguments to the underlying method of an API

    //path variables:

    @GetMapping("product/num1/{num1}/num2/{num3}")
    public Integer getProduct(@PathVariable Integer num1,@PathVariable Integer num2)
    {
        return num1 * num2;
    }


    // passing parameters using the hashmap (request params) of the http request

    @GetMapping("append/test")
    public String appendTest(@RequestParam String name)
    {
        return name + " test";
    }

    @GetMapping("append/name/age")
    public String appendTest(@RequestParam String name, @RequestParam String age)
    {
        return name + " " + age;
    }

    //combination of path variable and request param

    @GetMapping("append/first/{firstname}/lastName")
    public String appendNames(@PathVariable String firstname, @RequestParam String lastName)
    {
        return firstname + " " + lastName;
    }




    @GetMapping("age")
    public Integer showAge(@RequestBody Integer age)
    {
        return age;
    }


    @GetMapping("car")
    public Car showCar(@RequestBody Car obj)
    {
        return obj;
    }


}
