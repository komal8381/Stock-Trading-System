package com.trading.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Member extends Account {
    private double balance;
    private Date joiningDate;
}
