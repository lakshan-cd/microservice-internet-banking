package com.lakshancd.finance.internet_banking_fund_transfer_service.model.entity;

import com.lakshancd.finance.internet_banking_fund_transfer_service.model.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "fund_transfer")
public class FundTransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionReference;
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
}
