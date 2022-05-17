package com.maplr.testhockeygame.model;

import com.maplr.testhockeygame.model.enums.Position;
import lombok.*;

import javax.persistence.*;

/**
 * Player entity.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Player {

    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private Long number;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String lastname;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(nullable = false)
    private Boolean isCaptain;

   @ToString.Exclude
   @ManyToOne
   @JoinColumn(name = "TEAM_ID")
   private Team team;

}
