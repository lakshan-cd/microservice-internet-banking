package com.lakshancd.finance.internet_banking_user_service.model.dto.user;

import com.lakshancd.finance.internet_banking_user_service.model.dto.account.AccountResponse;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private List<AccountResponse> bankAccounts;
    private String identificationNumber;
    private Integer id;
    private String email;
}
