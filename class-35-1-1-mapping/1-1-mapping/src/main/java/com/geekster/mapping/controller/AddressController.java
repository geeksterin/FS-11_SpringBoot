package com.geekster.mapping.controller;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddressController {


    @Autowired
    AddressService addressService;

    @PostMapping("address")
    public String addAddress(@RequestBody Address newAddress)
    {
        return addressService.saveAddress(newAddress);
    }


    @PutMapping("address/{id}")
    public String addAddress(@PathVariable Integer id)
    {
        return addressService.updateAddress(id);
    }
}
