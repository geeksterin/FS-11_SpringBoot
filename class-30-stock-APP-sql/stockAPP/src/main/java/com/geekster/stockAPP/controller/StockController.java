package com.geekster.stockAPP.controller;


import com.geekster.stockAPP.model.Stock;
import com.geekster.stockAPP.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {


    @Autowired
    StockService stockService;

    @PostMapping("stocks")
    public String addStocks(@RequestBody List<Stock> newStocks)
    {
        return stockService.addStocks(newStocks);
    }

    @GetMapping("stocks")
    public List<Stock> getAllStocks()
    {
        return stockService.getAllStocks();
    }

    @DeleteMapping("stocks/id/{id}")
    public String removeStockById(@PathVariable Long id)
    {
        return stockService.removeStockById(id);
    }
}
