package com.lakshancd.finance.model.repository;

import com.lakshancd.finance.model.entity.UtilityPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityPaymentRepository extends JpaRepository<UtilityPaymentEntity, Long> {
}
