package com.trading.controllers;

import com.trading.converter.StockDtoConverter;
import com.trading.dto.StockDTO;
import com.trading.model.Stock;
import com.trading.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Apis to perform operations on stocks.
 */
@RestController
public class StockController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "/stock", method = RequestMethod.POST)
    public ResponseEntity<String> postStock(@RequestBody StockDTO stockDto) {
        LOGGER.debug("received post stock request with data {}", stockDto);

        try {
            validateStockDto(stockDto);
        } catch (Exception e) {
            LOGGER.error("Mandatory field not received", e);
            return ResponseEntity.badRequest().body("mandatory field not received");
        }
        StockDtoConverter converter = new StockDtoConverter();
        Stock stock = converter.apply(stockDto);
        stockService.recordStock(stock);
        return ResponseEntity.ok("Stock added with success");
    }

    private void validateStockDto(StockDTO stockDto) {
        checkNotNull(stockDto.getSymbol());
        checkNotNull(stockDto.getPrice());
    }

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public StockDTO getStock(@RequestParam String symbol) {
        LOGGER.debug("received getstock request for symbol {}", symbol);

        Stock stock = stockService.getStockDetails(symbol);
        return new StockDTO(stock.getSymbol(),stock.getPrice());
    }

    @RequestMapping(value = "/stocks/price", method = RequestMethod.GET)
    public Double getStockPrice(@RequestParam String symbol) {
        LOGGER.debug("received get stock price request for symbol {}", symbol);

        Double stockPrice = stockService.fetchStockPrice(symbol);
        return stockPrice;
    }

}
