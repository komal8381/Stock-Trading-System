package com.trading.repository;

import com.trading.model.Stock;
import org.springframework.stereotype.Repository;

/**
 * Local repository for stocks.
 *
 * @see Stock
 * @see LocalRepository
 */
@Repository
public class LocalStockRepository extends LocalRepository<Stock> {

    public LocalStockRepository() {
        super();
    }

}
