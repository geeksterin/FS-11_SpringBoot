package com.geekster.stockAPP.repo;

import com.geekster.stockAPP.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepo extends CrudRepository<Stock,Long> {
}
