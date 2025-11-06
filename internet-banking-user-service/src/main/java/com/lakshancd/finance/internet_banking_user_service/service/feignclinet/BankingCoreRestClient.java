package com.lakshancd.finance.internet_banking_user_service.service.feignclinet;

import com.lakshancd.finance.internet_banking_user_service.configuration.CustomFeignClientConfiguration;
import com.lakshancd.finance.internet_banking_user_service.model.dto.user.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "internet-banking-core-banking-service",configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/user/{identification}")
    UserResponse readUser(@PathVariable("identification") String identification);

}
