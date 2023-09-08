package org.geekster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiTest {


   @Autowired
    List<Integer> integerList;

    @GetMapping("api/v1/dukhiAatmaa")
    public String api1()
    {

        return "Deepak";
    }





    @GetMapping("v1/twice/{x}")
    public Integer getTwice(@PathVariable Integer x)
    {
        return 2*x;
    }


    @GetMapping("api/sum/{num1}/mainak/{num2}")
    public Integer sum(@PathVariable Integer num1,@PathVariable Integer num2)
    {
        return num1 + num2;
    }


    @PutMapping("api/sum/{num1}/mainak-1/{num2}")
    public String sumString(@PathVariable String num2,@PathVariable String num1)
    {
        return num1 + num2;
    }


    @PostMapping("number/{x}")
    public String addNumber(@PathVariable Integer x)
    {
        integerList.add(x);
        return x + " added";
    }


    @GetMapping("numbers")
    public List<Integer> getIntegerList()
    {
        return integerList;
    }





}
