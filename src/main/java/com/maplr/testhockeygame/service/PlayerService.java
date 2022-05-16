package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Implementation for the IPlayerService interface.
 */
@Service
@Transactional
public class PlayerService implements IPlayerService{

    @Autowired
    private IPlayerRepository playerRepository;

    @Autowired
    private ITeamService teamService;
    @Override
    public Player createPlayer(Player newPlayer, Team team) {
        newPlayer.setTeam(team);
        if(newPlayer.getIsCaptain()){
            this.removeCurrentCaptain(team);
        }
        return playerRepository.save(newPlayer);
    }


    @Override
    public Player setCaptain(Long playerId) throws PlayerNotFoundException, TeamNotFoundException {
        Player newCaptain = playerRepository.findById(playerId).orElse(null);
        if(newCaptain == null){
            throw new PlayerNotFoundException();
        }
        Team team = teamService.findById(newCaptain.getTeam().getId());
        this.removeCurrentCaptain(team);
        newCaptain.setIsCaptain(true);
        return playerRepository.save(newCaptain);
    }

    /**
     * Remove the current captain of the team.
     * @param team the team that need his captain to be removed.
     */
    private void removeCurrentCaptain(Team team){
        Player currentCaptain = team.getPlayers().stream()
                .filter(Player::getIsCaptain)
                .findAny()
                .orElse(null);
        if(currentCaptain != null){
            currentCaptain.setIsCaptain(false);
            playerRepository.save(currentCaptain);
        }


    }






}
