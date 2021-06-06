package com.dev.tenet.hackaton.operations.person_to_person_transfer;

import com.dev.tenet.hackaton.FieldDescription;
import com.dev.tenet.hackaton.feignClient.UserOperationStateFeignClient;
import com.dev.tenet.hackaton.operations.AbstractOperation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class PersonToPersonTransferOperation extends AbstractOperation {

    @Autowired
    UserOperationStateFeignClient userOperationStateFeignClient;

    public PersonToPersonTransferOperation() {
        super(new ArrayList<>());
    }

    public PersonToPersonTransferOperation(List<FieldDescription> filledFields) {
        super(filledFields);
    }

    @Override
    public void run(int userId) {
        List<FieldDescription> currentOperationRegistrationState =
                userOperationStateFeignClient.getCurrentOperationRegistrationState(userId, getOperationId());

        //сделать запрос в userService для начисления на счет таргет пользователю средств размера amount, выбрав их из current списка
        //сделать запрос на снятие средств у текущего юзера
        //уведомить какой-то топик о завершении операции


    }

    @Override
    public int getOperationId() {
        //будет тянуться из meta-inf
        return 1;
    }
}
