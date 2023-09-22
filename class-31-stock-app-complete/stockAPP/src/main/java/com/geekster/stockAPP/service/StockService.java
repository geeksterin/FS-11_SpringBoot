package com.geekster.stockAPP.service;


import com.geekster.stockAPP.model.Stock;
import com.geekster.stockAPP.model.Type;
import com.geekster.stockAPP.repo.IStockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public String updateStockById(Long id, double price) {

        Stock presentStock = stockRepo.findById(id).orElse(null);
        if(presentStock != null)
        {
            presentStock.setStockPrice(price);
            stockRepo.save(presentStock);
            return "price updated!!";
        }
        else {
            return "stock not found!";
        }
    }

    public List<Stock> getStocksByTypeLessEqualPrice(Type type, double price) {

        return stockRepo.findByStockTypeAndStockPriceLessThanEqualOrderByStockPriceDesc(type,price);
    }

    public List<Stock> getAllStocksLessPriceLessTime(double price, LocalDateTime time) {

        return stockRepo.findByStockPriceLessThanAndStockCreationTimeStampLessThanOrderByStockOwnerCountDesc(price,time);
    }


    @Transactional
    public String updateStockByType(float hike, Type stockType) {


        stockRepo.updateStockByType(hike,stockType.name());
        return "updated";
    }
}
