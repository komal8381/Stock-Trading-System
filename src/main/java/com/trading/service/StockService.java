package com.trading.service;


import com.trading.model.Stock;

/**
 * Stock service interface, that provides operations for storing and retrieving
 * stocks from the underlying repository.
 */
public interface StockService {

    /**
     * Fetches the stock price from underlying repository .
     *
     * @param stockSymbol stock symbol
     * @return stock price
     */
    Double fetchStockPrice(String stockSymbol);


    /**
     * Records a stock into the underlying repository.
     *
     * @param stock Stock
     */
    void recordStock(Stock stock);

    /**
     * Fetch stock details from underlying repository.
     *
     * @param stockSymbol String
     */
    Stock getStockDetails(String stockSymbol);

}
