package com.geekster.mapping.service;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {


    @Autowired
    IAddressRepo addressRepo;

    public String saveAddress(Address newAddress) {

        addressRepo.save(newAddress);
        return "added";
    }

    public String updateAddress(Integer id) {

        Address add = addressRepo.findById(id).get();
        add.setAddressName("c-226");
        addressRepo.save(add);
        return "updated";
    }
}
