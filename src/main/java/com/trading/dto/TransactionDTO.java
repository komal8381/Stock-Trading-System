package com.trading.dto;

import com.trading.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDTO {
    private final double price;
    private final int quantity;
    private final String stockSymbol;
    private final String transactionType;
}
