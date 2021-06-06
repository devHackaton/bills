package com.dev.tenet.hackaton.operations.person_to_person_transfer.steps;

import com.dev.tenet.hackaton.FieldDescription;
import com.dev.tenet.hackaton.feignClient.MetaInfoFeignClient;
import com.dev.tenet.hackaton.feignClient.UserFeignClient;
import com.dev.tenet.hackaton.operations.AbstractStep;
import com.dev.tenet.hackaton.operations.OperationStepState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmountSelectionStep extends AbstractStep {

    @Autowired
    UserFeignClient userFeignClient;
    @Autowired
    MetaInfoFeignClient metaInfoFeignClient;

    @Override
    public int run(List<FieldDescription> currentFieldsWithData, int userId, int operationId) {
        currentFieldsWithData.forEach(field -> {
            if ("Amount".equals(field.getName())) {
                //нужно проверить не привышен ли лимит переводов у данного пользователя, сделав запрос в userService
                boolean b = userFeignClient.checkIfTransferLimitIsNotExceeded(userId);
                if (!b) {
                    throw new IllegalArgumentException("Current user transfer limit is exeeded!");
                }
                int nextStepId = metaInfoFeignClient.notifyOperationStepFinish(userId, operationId,
                        field.getStepId(), OperationStepState.PASSED);
                if (nextStepId == -1) {
                    //уведомляем meta-inf о завершении регистрации операции, для выдачи экрана подтверждения
                    metaInfoFeignClient.notifyOperationRegistrationFinish(userId, operationId);
                }
            }
        });
        return 0;
    }

    @Override
    public int getStepId() {
        return 2;
    }
}
