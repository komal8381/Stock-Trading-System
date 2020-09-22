package com.trading.controllers;

import com.trading.converter.TrasanctionDtoConverter;
import com.trading.dto.TransactionDTO;
import com.trading.model.Transaction;
import com.trading.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkNotNull;

@RestController
@Validated
@RequestMapping("/api")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public ResponseEntity<String> postTrade(@RequestBody TransactionDTO transactionDto) {
        LOGGER.debug("received post trade request with data {}");
        TrasanctionDtoConverter converter = new TrasanctionDtoConverter();
        UserService service = new UserService();
        try {
            validateTradeDto(transactionDto);
        } catch (Exception e) {
            LOGGER.error("Mandatory field not received", e);
            return ResponseEntity.badRequest().body("mandatory field not received");
        }

        Transaction transaction = converter.apply(transactionDto);
        service.postTransaction(transaction);
        return ResponseEntity.ok("Trade added with success");
    }


    private void validateTradeDto(TransactionDTO transactionDto) {
        checkNotNull(transactionDto.getStockSymbol());
        checkNotNull(transactionDto.getTransactionType());
    }
}
