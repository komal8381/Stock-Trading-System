package com.trading.model;

import com.trading.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private final long time;
    private final double price;
    private final int quantity;
    private final String stockSymbol;
    private final TransactionType transactionType;
}
