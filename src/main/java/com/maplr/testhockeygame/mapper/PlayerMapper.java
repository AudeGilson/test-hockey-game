package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.dto.PlayerDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    /**
     * Changes the value of isCaptain attribute to null if at false in DTO to ensure that the
     * attribute will not be display in the response.
     * @param player the player Object
     * @param playerDto the DTO object
     */
    @AfterMapping
     static void ignoreIsCaptain(Player player, @MappingTarget PlayerDto playerDto){
        if(!playerDto.getIsCaptain()){
            playerDto.setIsCaptain(null);
        }
    }

    PlayerDto toDto(Player player);

    Player fromDto (PlayerDto playerDto);
}
