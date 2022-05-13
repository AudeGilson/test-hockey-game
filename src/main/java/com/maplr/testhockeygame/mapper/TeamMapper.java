package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.model.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { PlayerMapper.class })
public interface TeamMapper {

  TeamDto toDto(Team team);

  Team fromDto(TeamDto teamDto);
}
