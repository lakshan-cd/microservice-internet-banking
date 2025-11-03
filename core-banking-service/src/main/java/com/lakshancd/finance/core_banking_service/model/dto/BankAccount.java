package com.lakshancd.finance.core_banking_service.model.dto;

import com.lakshancd.finance.core_banking_service.model.enums.AccountStatus;
import com.lakshancd.finance.core_banking_service.model.enums.AccountType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccount {
    private Long id;
    private String number;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    private User user;
}
