package com.geekster.stockAPP.controller;


import com.geekster.stockAPP.model.Stock;
import com.geekster.stockAPP.model.Type;
import com.geekster.stockAPP.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("stocks/less/price/{price}/less/year/{time}")
    public List<Stock> getAllStocksLessPriceLessTime(@PathVariable double price,@PathVariable LocalDateTime time)
    {

        return stockService.getAllStocksLessPriceLessTime(price,time);
    }

    @DeleteMapping("stocks/id/{id}")
    public String removeStockById(@PathVariable Long id)
    {

        return stockService.removeStockById(id);
    }

    @PutMapping("stock/price/id")
    public String updateStockById(@RequestParam Long id,@RequestParam double price)
    {

        return stockService.updateStockById(id,price);
    }

    @PutMapping("stock/price/type")
    public String updateStockByType(@RequestParam float hike,@RequestParam Type stockType)
    {

        return stockService.updateStockByType(hike,stockType);
    }

    @GetMapping("stocks/type/{type}/price/lessOrEqual/{price}")
    public List<Stock> getStocksByTypeLessEqualPrice(@PathVariable Type type,@PathVariable double price)
    {

        return stockService.getStocksByTypeLessEqualPrice(type,price);
    }
}
