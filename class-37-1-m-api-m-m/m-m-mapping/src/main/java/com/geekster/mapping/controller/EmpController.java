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



}
