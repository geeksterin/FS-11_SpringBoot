package com.geekster.mapping.repo;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepo extends JpaRepository<Address,Integer> {
    Address findByEmployeesEmpId(Long empId);

    Address findByEmployees(Emp myEmp);
}
