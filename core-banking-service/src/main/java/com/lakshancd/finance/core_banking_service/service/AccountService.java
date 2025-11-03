package com.lakshancd.finance.core_banking_service.service;

import com.lakshancd.finance.core_banking_service.model.dto.BankAccount;
import com.lakshancd.finance.core_banking_service.model.dto.UtilityAccount;
import com.lakshancd.finance.core_banking_service.model.entity.BankAccountEntity;
import com.lakshancd.finance.core_banking_service.model.entity.UtilityAccountEntity;
import com.lakshancd.finance.core_banking_service.model.mapper.BankAccountMapper;
import com.lakshancd.finance.core_banking_service.model.mapper.UtilityAccountMapper;
import com.lakshancd.finance.core_banking_service.repository.BankAccountRepository;
import com.lakshancd.finance.core_banking_service.repository.UtilityAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final BankAccountMapper bankAccountMapper = new BankAccountMapper();
    private final UtilityAccountMapper utilityAccountMapper = new UtilityAccountMapper();

    private final BankAccountRepository bankAccountRepository;
    private final UtilityAccountRepository utilityAccountRepository;

    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity entity = bankAccountRepository.findByNumber(accountNumber).get();
        return bankAccountMapper.convertToDto(entity);
    }

    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).get();
        return utilityAccountMapper.convertToDto(utilityAccountEntity);
    }

    public UtilityAccount readUtilityAccount(Long id){
        return utilityAccountMapper.convertToDto(utilityAccountRepository.findById(id).get());
    }
}
