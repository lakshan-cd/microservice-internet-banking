package com.lakshancd.finance.internet_banking_user_service.model.dto;

import com.lakshancd.finance.internet_banking_user_service.model.enums.Status;
import lombok.Data;

@Data
public class User {
    private Long id;

    private String email;

    private String identification;

    private String password;

    private String authId;

    private Status status;
}
