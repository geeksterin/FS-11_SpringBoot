package com.geekster.mapping.service;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {


    @Autowired
    IAddressRepo addressRepo;


}
