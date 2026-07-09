package com.stocktrading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktrading.entity.StockEntity;
import com.stocktrading.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<StockEntity> getAllStocks() {
        return (List<StockEntity>) stockRepository.findAll();
    }

    public void save(StockEntity stockEntity) {
        stockRepository.save(stockEntity);
    }

    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    public StockEntity getStockById(Long id) {
        StockEntity stockEntity = null;
        Optional<StockEntity> optional = stockRepository.findById(id);
        if (optional.isPresent()) {
            stockEntity = optional.get();
        } else {
            System.out.println("Stock not found with ID: " + id);
        }
        return stockEntity;
    }

    public StockEntity getStockByName(String stockName) {
        StockEntity stockEntity = null;
        Optional<StockEntity> findByStockName = stockRepository.findByStockName(stockName);
        if (findByStockName.isPresent()) {
            stockEntity = findByStockName.get();
        } else {
            System.out.println("Stock not found with Name: " + stockName);
        }
        return stockEntity;
    }

    public StockEntity getStockBySymbol(String symbol) {
        StockEntity stockEntity = null;
        Optional<StockEntity> findBySymbol = stockRepository.findBySymbol(symbol);
        if (findBySymbol.isPresent()) {
            stockEntity = findBySymbol.get();
        } else {
            System.out.println("Stock not found with Symbol: " + symbol);
        }
        return stockEntity;
    }

    public StockEntity updateStock(StockEntity stockEntity, Long id) {
        StockEntity existingStock = stockRepository.findById(id).get();
        existingStock.setStockName(stockEntity.getStockName());
        existingStock.setSymbol(stockEntity.getSymbol());
        existingStock.setPrice(stockEntity.getPrice());
        existingStock.setQuantity(stockEntity.getQuantity());
        return stockRepository.save(existingStock);
    }
}