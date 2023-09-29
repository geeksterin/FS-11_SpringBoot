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



}
