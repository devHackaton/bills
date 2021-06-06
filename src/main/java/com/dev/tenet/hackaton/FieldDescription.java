package com.dev.tenet.hackaton;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldDescription {

    private int fieldId;
    private String fieldType;
    private int stepId;
    private String name;
    private String value;

}
