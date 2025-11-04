package com.lakshancd.finance.internet_banking_fund_transfer_service.service;

import com.lakshancd.finance.internet_banking_fund_transfer_service.model.dto.FundTransfer;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.dto.request.FundTransferRequest;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.dto.response.FundTransferResponse;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.entity.FundTransferEntity;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.enums.TransactionStatus;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.mapper.FundTransferMapper;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.repository.FundTransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FundTransferService {
    private final FundTransferRepository fundTransferRepository;
    private final FundTransferMapper fundTransferMapper = new FundTransferMapper();

    public FundTransferResponse fundTransfer(FundTransferRequest request) {
        log.info("Sending fund transfer request: {}", request.toString());
        FundTransferEntity entity = new FundTransferEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setStatus(TransactionStatus.PENDING);
        FundTransferEntity optFundTransfer = fundTransferRepository.save(entity);

        FundTransferResponse fundTransferResponse = new FundTransferResponse();
        fundTransferResponse.setTransactionId(UUID.randomUUID().toString());
        fundTransferResponse.setMessage("Success");

        return fundTransferResponse;
    }
    public List<FundTransfer> readAllTransfers(Pageable pageable) {
        return fundTransferMapper.convertToDtoList(fundTransferRepository.findAll(pageable).getContent());
    }

}
