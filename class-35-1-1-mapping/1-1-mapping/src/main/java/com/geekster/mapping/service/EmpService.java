package com.geekster.mapping.service;


import com.geekster.mapping.model.Emp;
import com.geekster.mapping.repo.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {


    @Autowired
    IEmpRepo empRepo;

    public List<Emp> getEmployees() {
        return empRepo.findAll();
    }

    public String saveEmp(Emp newEmp) {
        empRepo.save(newEmp);
        return "emp added";
    }
}
