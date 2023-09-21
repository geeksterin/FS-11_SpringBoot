package com.geekster.stockAPP.service;


import com.geekster.stockAPP.model.Stock;
import com.geekster.stockAPP.repo.IStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    IStockRepo stockRepo;

    public String addStocks(List<Stock> newStocks) {

        stockRepo.saveAll(newStocks);
        return "added";
    }

    public List<Stock> getAllStocks() {
        return (List<Stock>) stockRepo.findAll();
    }

    public String removeStockById(Long id) {

        stockRepo.deleteById(id);
        return "deleted";
    }
}
