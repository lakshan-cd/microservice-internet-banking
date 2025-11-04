package com.lakshancd.finance.internet_banking_fund_transfer_service.model.dto.response;

import lombok.Data;

@Data
public class FundTransferResponse {
    private String message;
    private String transactionId;
}
