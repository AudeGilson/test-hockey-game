package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Implementation for the TeamService interface.
 */
@Service
@Transactional
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private IPlayerService playerService;

    @Override
    public Team getTeam(Long year) throws TeamNotFoundException {
        Team team = teamRepository.findByYear(year);
        if(team != null){
            return team;
        }
        throw new TeamNotFoundException();

    }

    @Override
    public Player addPlayerToTeam(Long year, Player newPlayer) throws TeamNotFoundException {
        Team team = teamRepository.findByYear(year);
        if(team == null){
            throw new TeamNotFoundException();
        }
        return playerService.createPlayer(newPlayer, team);

    }

    @Override
    public Team findById(Long teamId) throws TeamNotFoundException {
        Team team = teamRepository.findById(teamId).orElse(null);
        if(team ==null){
            throw new TeamNotFoundException();
        }
        return team;
    }


}
