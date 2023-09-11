package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import test.Dog;

import java.util.List;


@RestController
public class APITest {

    @Autowired
    Dog dog;


    @Autowired
    @Qualifier("orangeCat")
    Cat cat;

    @Autowired
    List<Integer> numbers;

    @GetMapping("cat")
    public Cat getCat()
    {
        return cat;
    }
    // get all the numbers in the list

    @GetMapping("numbers")
    public List<Integer> getNumbers()
    {
        return numbers;
    }

    //clear out the whole List

    @DeleteMapping("numbers")
    public String clearNumbers()
    {
        numbers.clear();
        return "Cleared";
    }

    //I want to add a number in the list

    @PostMapping("ten")
    public String addNumber()
    {
        numbers.add(10);
        return "Added";
    }

    //I want to update the values : twice

    @PutMapping("twice")
    public List<Integer> twiceNumber()
    {
        for(int i =0;i<numbers.size();i++)
        {
            numbers.add(i,numbers.get(i)*2);


        }

        return numbers;
    }


    //-------------------------------------------------------------

}
