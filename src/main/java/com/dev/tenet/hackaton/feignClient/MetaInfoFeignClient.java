package com.dev.tenet.hackaton.feignClient;

import com.dev.tenet.hackaton.operations.OperationStepState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "meta-info")
public interface MetaInfoFeignClient {

    @GetMapping(value = "/meta-info/notifyRegistrationFinish/{userId}/{operationId}")
    void notifyOperationRegistrationFinish(@PathVariable("userId")Integer userId,
                                           @PathVariable("operationId")Integer operationId);

    @GetMapping(value = "/meta-info/notifyOperationStepFinish/{userId}/{operationId}/{stepId}/{stepState}")
    int notifyOperationStepFinish(@PathVariable("userId")Integer userId,
                                  @PathVariable("operationId")Integer operationId,
                                  @PathVariable("stepId")Integer stepId,
                                  @PathVariable("stepState")OperationStepState operationStepState);
}
