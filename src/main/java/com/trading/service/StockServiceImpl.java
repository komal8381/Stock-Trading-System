package com.trading.service;

import com.trading.model.Stock;
import com.trading.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class StockServiceImpl implements StockService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);
    private final GenericRepository<Stock> stockRepository;

    @Autowired
    public StockServiceImpl(GenericRepository<Stock> stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Double fetchStockPrice(String symbol) {
        Stock stock = stockRepository.findOne(withSymbol(symbol));
        return stock.getPrice();
    }

    public static Predicate<Stock> withSymbol(String symbol) {
        return stock -> stock.getSymbol().equals(symbol);
    }

    @Override
    public Stock getStockDetails(String stockSymbol) {
        Stock stock = stockRepository.findOne(withSymbol(stockSymbol));
        return stock;
    }


    @Override
    public void recordStock(Stock stock) {
        LOGGER.info("Saving stock :" + stock.getSymbol());
        stockRepository.save(stock);
    }

}
