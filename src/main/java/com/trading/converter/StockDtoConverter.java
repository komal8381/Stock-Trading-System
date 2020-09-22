package com.trading.converter;

import com.trading.dto.StockDTO;
import com.trading.model.Stock;

import java.util.function.Function;

public class StockDtoConverter implements Function<StockDTO, Stock> {
    @Override
    public Stock apply(StockDTO stockDTO) {
        double price = stockDTO.getPrice();
        String symbol = stockDTO.getSymbol();

        return new Stock(symbol, price);
    }
}
