package com.lakshancd.finance.internet_banking_user_service.exception.custom;


import com.lakshancd.finance.internet_banking_user_service.exception.SimpleBankingGlobalException;

public class InvalidBankingUserException extends SimpleBankingGlobalException {
    public InvalidBankingUserException(String message, String code) {
        super(message, code);
    }
}
