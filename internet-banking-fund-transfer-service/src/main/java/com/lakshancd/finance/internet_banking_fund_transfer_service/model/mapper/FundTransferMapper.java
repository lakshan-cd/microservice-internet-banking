package com.lakshancd.finance.internet_banking_fund_transfer_service.model.mapper;

import com.lakshancd.finance.internet_banking_fund_transfer_service.mapper.BaseMapper;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.dto.FundTransfer;
import com.lakshancd.finance.internet_banking_fund_transfer_service.model.entity.FundTransferEntity;
import org.springframework.beans.BeanUtils;

public class FundTransferMapper extends BaseMapper<FundTransferEntity , FundTransfer> {
    @Override
    public FundTransferEntity convertToEntity(FundTransfer dto, Object... args) {
        FundTransferEntity entity = new FundTransferEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public FundTransfer convertToDto(FundTransferEntity entity, Object... args) {
        FundTransfer dto = new FundTransfer();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
}
