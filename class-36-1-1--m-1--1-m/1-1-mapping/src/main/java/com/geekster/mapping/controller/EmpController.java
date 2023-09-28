package com.geekster.mapping.controller;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.model.Emp;
import com.geekster.mapping.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("emps/{empId}/address")
    public Address getAddressOfEmployee(@PathVariable Long empId)
    {

        return empService.getAddressOfEmployee(empId);
    }

    @GetMapping("employee/address/{addId}")
    public List<Emp> getEmpByAddId(@PathVariable Integer addId)
    {

        return empService.getEmpByAddId(addId);
    }

}
