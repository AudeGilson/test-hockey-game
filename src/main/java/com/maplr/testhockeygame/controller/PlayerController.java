package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


/**
 * Endpoint for Player.
 */
@RestController()
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @Autowired
    private PlayerMapper playerMapper;

    /**
     * Change the team captain for the player whose id has been passed.
     * @param id the player id
     * @return A code 200 with the new captain
     * @throws PlayerNotFoundException if the player is not found
     * @throws TeamNotFoundException if the team of the player is not found
     */
    @PutMapping("/captain/{ID}")
    public ResponseEntity<PlayerDto> setCaptain(@PathVariable(value = "ID") Long id) throws PlayerNotFoundException, TeamNotFoundException {
        return ResponseEntity.ok( playerMapper.toDto(playerService.setCaptain(id)));
    }


}

