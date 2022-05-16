package com.maplr.testhockeygame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.maplr.testhockeygame.model.enums.Position;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDto {
    private Long number;
    private String name;
    private String lastname;
    private Position position;
    private Boolean isCaptain;
}
