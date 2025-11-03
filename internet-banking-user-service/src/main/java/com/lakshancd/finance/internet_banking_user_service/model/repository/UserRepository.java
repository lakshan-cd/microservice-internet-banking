package com.lakshancd.finance.internet_banking_user_service.model.repository;

import com.lakshancd.finance.internet_banking_user_service.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity , Long> {
}
