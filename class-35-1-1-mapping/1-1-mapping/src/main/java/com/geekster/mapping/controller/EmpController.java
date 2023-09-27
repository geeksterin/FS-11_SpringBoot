package com.geekster.mapping.controller;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.model.Emp;
import com.geekster.mapping.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("emps")
    public List<Emp> getEmployees()
    {
        return empService.getEmployees();
    }

    @PostMapping("emp")
    public String addEmp(@RequestBody Emp newEmp)
    {
        return empService.saveEmp(newEmp);
    }


}
