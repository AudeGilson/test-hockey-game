package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository for the player entity.
 */
@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {



}
