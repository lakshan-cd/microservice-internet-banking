package com.lakshancd.finance.core_banking_service.repository;

import com.lakshancd.finance.core_banking_service.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity , Long> {
    Optional<UserEntity> findByIdentificationNumber(String identificationNumber);
}
