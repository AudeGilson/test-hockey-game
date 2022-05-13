package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.mapper.TeamMapper;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.service.ITeamService;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

///api/team/{year}
@RestController
@RequestMapping("/api/team")
public class TeamController {
     @Autowired
     ITeamService teamService;

     @Autowired
     TeamMapper teamMapper;


    @GetMapping("/{year}")
    public TeamDto getTeamByYear(@PathVariable Long year){
        return teamMapper.toDto(teamService.getTeam(year));

    }
}
