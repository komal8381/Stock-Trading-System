package com.trading.converter;

import com.trading.dto.TransactionDTO;
import com.trading.enumeration.TransactionType;
import com.trading.model.Transaction;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.function.Function;

public class TrasanctionDtoConverter implements Function<TransactionDTO, Transaction> {
    @Override
    public Transaction apply(TransactionDTO tradeDto) {
        double price = tradeDto.getPrice();
        int quantity = tradeDto.getQuantity();
        String stockSymbol = tradeDto.getStockSymbol();
        TransactionType indicator = TransactionType.valueOf(tradeDto.getTransactionType());

        return new Transaction(
                new DateTime(DateTimeZone.UTC).getMillis(),
                price, quantity, stockSymbol, indicator);
    }
}
