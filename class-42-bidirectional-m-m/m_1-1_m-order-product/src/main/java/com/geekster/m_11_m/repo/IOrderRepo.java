package com.geekster.m_11_m.repo;

import com.geekster.m_11_m.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Integer> {
}
