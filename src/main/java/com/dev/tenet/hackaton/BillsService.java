package com.dev.tenet.hackaton;

import com.dev.tenet.hackaton.operations.AbstractOperation;
import com.dev.tenet.hackaton.operations.AbstractStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillsService {

    @Autowired
    List<AbstractOperation> operations;
    @Autowired
    List<AbstractStep> operationSteps;

    Map<Integer, AbstractOperation> operationMap = new HashMap<>();
    Map<Integer, AbstractStep> operationStepMap = new HashMap<>();

    @PostConstruct
    void init() {
        //заполняем мапу операций
        operations.forEach(operation -> operationMap.put(operation.getOperationId(), operation));
        //заполняем мапу шагов операций
        operationSteps.forEach(operationStep -> operationStepMap.put(operationStep.getStepId(), operationStep));
    }

    void processOperation(int userId, int operationId) {
        operationMap.get(operationId).run(userId);
    }

    public void processOperationStep(int userId, int operationId, int stepId,
                                     List<FieldDescription> currentFieldsWithData) {
        operationStepMap.get(stepId)
                .run(currentFieldsWithData, userId, operationId);
    }
}
