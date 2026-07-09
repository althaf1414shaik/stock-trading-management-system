package com.stocktrading.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktrading.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    Optional<StockEntity> findByStockName(String stockName);
    Optional<StockEntity> findBySymbol(String symbol);
}