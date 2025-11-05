package com.lakshancd.finance.internet_banking_user_service.exception.custom;


import com.lakshancd.finance.internet_banking_user_service.exception.SimpleBankingGlobalException;

public class InvalidEmailException extends SimpleBankingGlobalException {
    public InvalidEmailException(String message, String code) {
        super(message, code);
    }
}
