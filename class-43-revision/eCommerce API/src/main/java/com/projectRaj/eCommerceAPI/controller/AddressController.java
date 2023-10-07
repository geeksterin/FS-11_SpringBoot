package com.projectRaj.eCommerceAPI.controller;

import com.projectRaj.eCommerceAPI.models.Address;
import com.projectRaj.eCommerceAPI.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("api/addresses")
    public String createAddresses(@Valid @RequestBody List<Address> addresses) {
       return addressService.createAddresses(addresses);
    }

}
