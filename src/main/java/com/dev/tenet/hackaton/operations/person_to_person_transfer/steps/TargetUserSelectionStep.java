package com.dev.tenet.hackaton.operations.person_to_person_transfer.steps;

import com.dev.tenet.hackaton.FieldDescription;
import com.dev.tenet.hackaton.feignClient.MetaInfoFeignClient;
import com.dev.tenet.hackaton.feignClient.UserOperationStateFeignClient;
import com.dev.tenet.hackaton.operations.AbstractStep;
import com.dev.tenet.hackaton.operations.OperationStepState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TargetUserSelectionStep extends AbstractStep {

    @Autowired
    MetaInfoFeignClient metaInfoFeignClient;
    @Autowired
    UserOperationStateFeignClient userOperationStateFeignClient;

    @Override
    public int run(List<FieldDescription> currentFieldsWithData, int userId, int operationId) {
        currentFieldsWithData.forEach(field -> {
            if ("Username".equals(field.getName())) {
                if (field.getValue() == null) {
                    throw new IllegalArgumentException("Username is empty!");
                }
                //дергаем UserStateService и записываем в него филды данного шага
                userOperationStateFeignClient.saveCurrentFieldData(currentFieldsWithData, userId, operationId);
                //дергаем MetaInfoService передавая ему стейт данного шага, id операции и id шага
                metaInfoFeignClient.notifyOperationStepFinish(operationId,
                        getStepId(), OperationStepState.PASSED);
            }
        });
        return 0;
    }

    @Override
    public int getStepId() {
        return 1;
    }
}
