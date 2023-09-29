package com.geekster.mapping.repo;

import com.geekster.mapping.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepo extends JpaRepository<Address,Integer> {
}
