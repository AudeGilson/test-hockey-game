package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.mapper.TeamMapper;
import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


/**
 * Endpoint for team.
 */
@RestController
@RequestMapping("/api/team")
public class TeamController {
     @Autowired
     private ITeamService teamService;

     @Autowired
     private TeamMapper teamMapper;

     @Autowired
     private PlayerMapper playerMapper;


    /**
     * Retrieves the team of a year.
     * @param year the year
     * @return a code 200 with the team
     * @throws TeamNotFoundException if no team is found for the giving year
     */
    @GetMapping("/{year}")
    public ResponseEntity<TeamDto> getTeamsByYear(@PathVariable Long year) throws TeamNotFoundException {
            return ResponseEntity.ok(teamMapper.toDto(teamService.getTeam(year)));
    }


    /**
     * Add a new player in the team of a specific year.
     * @param year the year
     * @param newPlayer the player to add
     * @return Code 201 with the new added player
     * @throws TeamNotFoundException if no team is found for the giving year
     */
    @PostMapping("{year}")
    public ResponseEntity<PlayerDto> createPlayer(@PathVariable Long year, @RequestBody PlayerDto newPlayer) throws TeamNotFoundException {
        Player createdPlayer = teamService.addPlayerToTeam(year, playerMapper.fromDto(newPlayer));
        return ResponseEntity.created(URI.create("")).body(playerMapper.toDto(createdPlayer));
    }

}
