package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.model.enums.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TeamService implements ITeamService {


    @Override
    public Team getTeam(Long year) {
        ArrayList<Player> players = new ArrayList<>();
        Team team = Team.builder()
                .id(1L)
                .coach("coach")
                .year(year).build();
        Player player1 = new Player(1L, "1","1", Position.defenseman, false, team);
        Player player2 = new Player(2L, "2","2", Position.defenseman, true, team);
        players.add(player1);
        players.add(player2);
        team.setPlayers(players);
        return team;

    }
}
