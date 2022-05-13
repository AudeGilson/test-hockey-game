package com.maplr.testhockeygame.model;

import com.maplr.testhockeygame.model.enums.Position;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private Long number;
    private String name;
    private String lastname;
    private Position position;
    private Boolean isCaptain;
   @ToString.Exclude
   private Team team;

}
