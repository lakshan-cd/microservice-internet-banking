package com.lakshancd.finance.core_banking_service.model.mapper;

import com.lakshancd.finance.core_banking_service.model.dto.User;
import com.lakshancd.finance.core_banking_service.model.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserMapper extends BaseMapper<UserEntity , User>{
    private final BankAccountMapper bankAccountMapper = new BankAccountMapper();

    @Override
    public UserEntity convertToEntity(User dto, Object... args) {
        UserEntity userEntity  = new UserEntity();
        if (dto != null){
            BeanUtils.copyProperties(dto, userEntity , "accounts");
            userEntity.setAccounts(bankAccountMapper.convertToEntityList(dto.getBankAccounts()));
        }
        return userEntity;
    }

    @Override
    public User convertToDto(UserEntity entity, Object... args) {
        User dto = new User();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "accounts");
            dto.setBankAccounts(bankAccountMapper.convertToDtoList(entity.getAccounts()));
        }
        return dto;
    }
}
