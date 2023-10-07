package com.projectRaj.eCommerceAPI.repo;

import com.projectRaj.eCommerceAPI.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
