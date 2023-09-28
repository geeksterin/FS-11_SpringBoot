package com.geekster.mapping.service;


import com.geekster.mapping.model.Address;
import com.geekster.mapping.model.Emp;
import com.geekster.mapping.repo.IAddressRepo;
import com.geekster.mapping.repo.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {


    @Autowired
    IEmpRepo empRepo;

    @Autowired
    IAddressRepo addressRepo;



    public List<Emp> getEmployees() {
        return empRepo.findAll();
    }

    public String saveEmp(Emp newEmp) {
        empRepo.save(newEmp);
        return "emp added";
    }

    public Address getAddressOfEmployee(Long empId) {

        Emp employee = empRepo.findById(empId).orElseThrow();

        return employee.getAddress();
    }

    public List<Emp> getEmpByAddId(Integer addId) {

        Address address = addressRepo.findById(addId).orElseThrow();
        return empRepo.findByAddress(address);
    }
}
