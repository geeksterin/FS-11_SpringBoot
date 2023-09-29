package com.geekster.mapping.controller;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AddressController {


    @Autowired
    AddressService addressService;


}
