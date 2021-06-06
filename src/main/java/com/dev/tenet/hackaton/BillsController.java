package com.dev.tenet.hackaton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillsController {

    @Autowired
    BillsService billsService;

    @PostMapping("/processOperationStep/{operationId}/{stepId}/{userId}")
    public void processOperationStep(@PathVariable("userId")Integer userId,
                                     @PathVariable("operationId")Integer operationId,
                                     @PathVariable("stepId")Integer stepId,
                                     @RequestBody List<FieldDescription> currentFields) {
        billsService.processOperationStep(userId, operationId, stepId, currentFields);
    }

    @PostMapping("/processOperationStep/{operationId}/{userId}")
    public void processOperation(@PathVariable("userId")Integer userId,
                                     @PathVariable("operationId")Integer operationId,
                                     @RequestBody List<FieldDescription> currentFields) {
        billsService.processOperation(userId, operationId);
    }
}
