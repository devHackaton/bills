package com.dev.tenet.hackaton.feignClient;

import com.dev.tenet.hackaton.FieldDescription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-operation-registration-state")
public interface UserOperationStateFeignClient {

    @PostMapping(value = "/userOperationRegistrationState/saveCurrentFieldData/{userId}/{operationId}")
    void saveCurrentFieldData(@RequestBody List<FieldDescription> fieldDescription);

    @GetMapping(value = "/currentOperationRegistrationState/{userId}/{operationId}")
    List<FieldDescription> getCurrentOperationRegistrationState(@PathVariable("userId")Integer userId,
                                                                @PathVariable("operationId")Integer operationId);

}
