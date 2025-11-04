package com.lakshancd.finance.internet_banking_fund_transfer_service.model.repository;

import com.lakshancd.finance.internet_banking_fund_transfer_service.model.entity.FundTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundTransferRepository extends JpaRepository<FundTransferEntity , Long> {
}
