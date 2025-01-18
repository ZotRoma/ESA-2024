package com.example.labrest.helper;

import com.example.labrest.model.Game;
import com.example.labrest.model.Player;
import com.example.labrest.model.PlayerGameStatistic;

public class Statistic {
    private Integer PlayerGameId;
    private Integer GameId;
    private Integer PlayerId;
    private String HeroName;
    private Integer Kills;
    private Integer Deaths;
    private Integer Assists;
    private Integer LastHit;

    public Statistic(PlayerGameStatistic playerGameStatistic) {
        this.PlayerGameId = playerGameStatistic.getPlayerGameId();
        this.Assists = playerGameStatistic.getAssists();
        this.Kills = playerGameStatistic.getKills();
        this.Deaths = playerGameStatistic.getDeaths();
        this.LastHit = playerGameStatistic.getLastHit();
    }
}
