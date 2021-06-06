package com.dev.tenet.hackaton.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user")
public interface UserFeignClient {

    @RequestMapping(value = "/user/checkTransferLimit/{userId}", method = RequestMethod.GET)
    boolean checkIfTransferLimitIsNotExceeded(@PathVariable("userId")Integer userId);

}
