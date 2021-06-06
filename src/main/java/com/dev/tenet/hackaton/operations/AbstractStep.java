package com.dev.tenet.hackaton.operations;

import com.dev.tenet.hackaton.FieldDescription;

import java.util.List;

public abstract class AbstractStep {

    /**
     *
     * @param currentFieldsWithData
     * @param userId
     * @param operationId
     * @return идентификатор следущего шага операции
     */
    public abstract int run(List<FieldDescription> currentFieldsWithData, int userId, int operationId);

    public abstract int getStepId();

}
