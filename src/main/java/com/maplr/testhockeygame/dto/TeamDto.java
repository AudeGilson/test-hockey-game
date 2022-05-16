package com.maplr.testhockeygame.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TeamDto {
    private Long id;
    private String coach;
    private Long year;
    private ArrayList<PlayerDto> players;

}
