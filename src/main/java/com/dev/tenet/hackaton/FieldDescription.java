package com.dev.tenet.hackaton;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FieldDescription {

    private int fieldId;
    private String fieldType;
    private int stepId;
    private String name;
    private String value;

}
