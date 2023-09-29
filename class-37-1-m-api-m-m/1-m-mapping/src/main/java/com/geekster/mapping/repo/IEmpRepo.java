package com.geekster.mapping.repo;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmpRepo extends JpaRepository<Emp,Long> {

    //List<Emp> findByAddress(Address address);
}
