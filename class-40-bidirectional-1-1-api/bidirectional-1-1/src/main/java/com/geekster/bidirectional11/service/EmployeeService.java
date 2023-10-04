package com.geekster.bidirectional11.service;


import com.geekster.bidirectional11.model.Emp;
import com.geekster.bidirectional11.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo employeeRepo;


    public List<Emp> getAllEmp() {
        return employeeRepo.findAll();
    }

    public String addEmp(Emp newEmp) {

        //hacks
        if(newEmp.getAddress()!=null) {
            newEmp.getAddress().setEmployee(newEmp);
        }

        employeeRepo.save(newEmp);
        return "added employee";
    }
}
