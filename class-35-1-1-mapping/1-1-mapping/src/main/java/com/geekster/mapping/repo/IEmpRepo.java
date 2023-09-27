package com.geekster.mapping.repo;

import com.geekster.mapping.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpRepo extends JpaRepository<Emp,Long> {
}
