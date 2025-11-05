package com.lakshancd.finance.core_banking_service.exception.custom;

import com.lakshancd.finance.core_banking_service.exception.GlobalErrorCode;
import com.lakshancd.finance.core_banking_service.exception.SimpleBankingGlobalException;

public class EntityNotFoundException extends SimpleBankingGlobalException {
    public EntityNotFoundException(){
        super("Requested entity not present in the DB.", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }
    public EntityNotFoundException (String message) {
        super(message, GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }

}
