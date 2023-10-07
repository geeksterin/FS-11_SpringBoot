package com.projectRaj.eCommerceAPI.repo;

import com.projectRaj.eCommerceAPI.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
