package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;

/**
 * Service for the Team.
 */
public interface ITeamService {

    Team getTeam (Long year) throws TeamNotFoundException;

    Player addPlayerToTeam (Long year, Player newPlayer) throws TeamNotFoundException;

    Team findById(Long teamId) throws TeamNotFoundException;
}
