package com.trading.client;

public class StockExchangeClient {
    private static StockExchangeClient instance = null;

    public static StockExchangeClient getInstance() {
        if (instance == null) {
            instance = new StockExchangeClient();
        }
        return instance;
    }

    public boolean placeOrder() {
        boolean returnStatus = getInstance().submitOrder();
        return returnStatus;
    }

    private boolean submitOrder() {
        throw new UnsupportedOperationException();
    }

    public String searchSymbol(String str) {
        throw new UnsupportedOperationException();
    }
}
