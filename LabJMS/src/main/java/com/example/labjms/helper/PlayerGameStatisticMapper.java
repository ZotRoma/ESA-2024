package com.example.labjms.helper;

import com.example.labjms.model.Game;
import com.example.labjms.model.Player;
import com.example.labjms.model.PlayerGameStatistic;

import java.util.HashMap;
import java.util.Map;

public class PlayerGameStatisticMapper {
    public static Map<String, Object> map(PlayerGameStatistic playerGameStatistic, Game game, Player player) {
        Map<String, Object> map = new HashMap<>();
        map.put("playerGameId", playerGameStatistic.getPlayerGameId());
        map.put("heroName", playerGameStatistic.getHeroName());
        map.put("kills", playerGameStatistic.getKills());
        map.put("deaths", playerGameStatistic.getDeaths());
        map.put("assists", playerGameStatistic.getAssists());
        map.put("lastHit", playerGameStatistic.getLastHit());
        map.put("gameId", playerGameStatistic.getGame().getGameId());
        map.put("playerId", playerGameStatistic.getPlayer().getPlayerId());
        return map;
    }
}
