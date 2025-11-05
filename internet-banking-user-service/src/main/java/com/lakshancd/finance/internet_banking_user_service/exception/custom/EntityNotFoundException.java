package com.lakshancd.finance.internet_banking_user_service.exception.custom;

import com.lakshancd.finance.internet_banking_user_service.exception.GlobalErrorCode;
import com.lakshancd.finance.internet_banking_user_service.exception.SimpleBankingGlobalException;

public class EntityNotFoundException extends SimpleBankingGlobalException {
    public EntityNotFoundException(){
        super("Requested entity not present in the DB.", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }
    public EntityNotFoundException (String message) {
        super(message, GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }

}
