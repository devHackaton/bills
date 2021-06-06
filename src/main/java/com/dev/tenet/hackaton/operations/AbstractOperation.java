package com.dev.tenet.hackaton.operations;

import com.dev.tenet.hackaton.FieldDescription;

import java.util.List;

public abstract class AbstractOperation {

    final List<FieldDescription> filledFields;

    public AbstractOperation(List<FieldDescription> filledFields) {
        this.filledFields = filledFields;
    }

    public abstract void run(int userId);

    public abstract int getOperationId();

}
