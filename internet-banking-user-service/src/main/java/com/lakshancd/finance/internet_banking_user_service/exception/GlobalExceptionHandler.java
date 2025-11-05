package com.lakshancd.finance.internet_banking_user_service.exception;

import com.lakshancd.finance.internet_banking_user_service.exception.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SimpleBankingGlobalException.class)
    protected ResponseEntity handleGlobalException(SimpleBankingGlobalException simpleBankingGlobalException , Locale local){
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .code(simpleBankingGlobalException.getCode())
                        .message(simpleBankingGlobalException.getMessage())
                        .build());
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e , Locale local){
        return ResponseEntity
                .badRequest()
                .body("Exception occur inside API " + e);
    }
}
