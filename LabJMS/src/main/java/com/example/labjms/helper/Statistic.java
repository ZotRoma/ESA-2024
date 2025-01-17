package com.example.labjms.helper;

import com.example.labjms.model.PlayerGameStatistic;

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
