package com.maplr.testhockeygame.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.ArrayList;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    private Long id;
    private String coach;
    private Long year;
    private ArrayList<Player> players;
}
