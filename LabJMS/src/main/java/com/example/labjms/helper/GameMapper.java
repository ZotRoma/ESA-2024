package com.example.labjms.helper;

import com.example.labjms.model.Game;
import com.example.labjms.model.Player;
import com.example.labjms.model.PlayerGameStatistic;

import java.util.HashMap;
import java.util.Map;

public class GameMapper {
    public static Map<String, Object> map(Game game) {
        Map<String, Object> map = new HashMap<>();
        map.put("gameId", game.getGameId());
        map.put("numberKillsRadiant", game.getNumberKillsRadiant());
        map.put("numberKillsDire", game.getNumberKillsDire());
        map.put("whoWin", game.getWhoWin());
        map.put("time", game.getTime());
        return map;
    }
}
