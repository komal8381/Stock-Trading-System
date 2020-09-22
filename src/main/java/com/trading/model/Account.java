package com.trading.model;

import com.trading.enumeration.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String name;
    private String emailId;
    private String phone;
    private Address address;
    private AccountStatus accountStatus;
}
