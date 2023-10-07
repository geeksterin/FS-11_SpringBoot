package com.projectRaj.eCommerceAPI.service;

import com.projectRaj.eCommerceAPI.models.Address;
import com.projectRaj.eCommerceAPI.models.Product;
import com.projectRaj.eCommerceAPI.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public String createAddresses(List<Address> addresses) {
            addressRepository.saveAll(addresses);
            return addresses.size()+" Addresses has been added into address repository";
    }
}
