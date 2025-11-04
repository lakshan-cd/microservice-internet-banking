package com.lakshancd.finance.internet_banking_fund_transfer_service.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundTransferRequest {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private String authID;
}
