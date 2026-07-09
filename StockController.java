package com.stocktrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stocktrading.entity.StockEntity;
import com.stocktrading.service.StockService;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/stocks")
    public List<StockEntity> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping("/save")
    public void saveStock(@RequestBody StockEntity stockEntity) {
        stockService.save(stockEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStock(@PathVariable("id") Long id) {
        stockService.delete(id);
    }

    @GetMapping("/getbyid/{id}")
    public StockEntity getStockById(@PathVariable("id") Long id) {
        return stockService.getStockById(id);
    }

    @GetMapping("/getbyname/{stockName}")
    public StockEntity getStockByName(@PathVariable("stockName") String stockName) {
        return stockService.getStockByName(stockName);
    }

    @GetMapping("/getbysymbol/{symbol}")
    public StockEntity getStockBySymbol(@PathVariable("symbol") String symbol) {
        return stockService.getStockBySymbol(symbol);
    }

    @PutMapping("/update/{id}")
    public StockEntity updateStock(@PathVariable("id") Long id, @RequestBody StockEntity stockEntity) {
        return stockService.updateStock(stockEntity, id);
    }
}