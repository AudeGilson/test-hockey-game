package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Team entity.
 */
@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {

    Team findByYear(Long year);
}
