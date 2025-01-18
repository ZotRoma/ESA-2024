package com.example.labjms.helper;

import com.example.labjms.model.Game;
import com.example.labjms.model.Player;
import com.example.labjms.model.PlayerGameStatistic;

import java.util.HashMap;
import java.util.Map;

public class PlayerMapper {
    public static Map<String, Object> map(Player player) {
        Map<String, Object> map = new HashMap<>();
        map.put("playerId", player.getPlayerId());
        map.put("rating", player.getRating());
        map.put("favoriteCharacterName", player.getFavoriteCharacterName());
        map.put("name", player.getName());
        return map;
    }
}
