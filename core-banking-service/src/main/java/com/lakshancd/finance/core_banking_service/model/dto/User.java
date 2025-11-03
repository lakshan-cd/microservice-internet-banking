package com.lakshancd.finance.core_banking_service.model.dto;

import com.lakshancd.finance.core_banking_service.model.entity.BankAccountEntity;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;
    private List<BankAccount> bankAccounts;
}
