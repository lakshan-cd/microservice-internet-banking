package com.lakshancd.finance.internet_banking_user_service.model.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponse {
    private String number;
    private BigDecimal actualBalance;
    private Integer id;
    private String type;
    private String status;
    private BigDecimal availableBalance;
}
