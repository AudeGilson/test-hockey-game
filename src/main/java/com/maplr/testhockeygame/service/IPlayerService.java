package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;

/**
 * Service for the player.
 */
public interface IPlayerService {

    Player createPlayer(Player newPlayer, Team team);


    Player setCaptain (Long playerId) throws PlayerNotFoundException, TeamNotFoundException;


}
