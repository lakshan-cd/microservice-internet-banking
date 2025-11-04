package com.lakshancd.finance.internet_banking_fund_transfer_service.controller;

import com.lakshancd.finance.internet_banking_fund_transfer_service.model.dto.request.FundTransferRequest;
import com.lakshancd.finance.internet_banking_fund_transfer_service.service.FundTransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/transfer")
public class FundTransferController {
    private final FundTransferService fundTransferService;

    @PostMapping
    public ResponseEntity sendFundTransfer(@RequestBody FundTransferRequest request){
        log.info("Initiating fund transfer with request: {}", request.toString());
        return ResponseEntity.ok(fundTransferService.fundTransfer(request));
    }

    @GetMapping
    public ResponseEntity readFundTransfers (Pageable pageable) {
        log.info("Reading fund transfers from core");
        return ResponseEntity.ok(fundTransferService.readAllTransfers(pageable));
    }
}
