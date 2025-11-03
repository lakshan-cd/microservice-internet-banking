package com.lakshancd.finance.internet_banking_user_service.model.dto;

import com.lakshancd.finance.internet_banking_user_service.model.enums.Status;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private Status status;
}
