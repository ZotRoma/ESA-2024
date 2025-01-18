package com.example.labjms.controller;


import com.example.labjms.helper.Helper;
import com.example.labjms.helper.PlayerList;
import com.example.labjms.model.Player;
import com.example.labjms.request.PlayerRequest;
import com.example.labjms.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value ="/players",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE})
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<Object> showPlayers(@RequestHeader("Accept") String acceptHeader) {
        List<Player> allPlayers = playerService.findAllPlayers();
        PlayerList playerList = new PlayerList();
        playerList.setPlayers(allPlayers);
        return Helper.response(playerList,acceptHeader,"/players.xslt",PlayerList.class);
    }

    @PostMapping
    public ResponseEntity<Object> addPlayer(@RequestHeader("Accept") String acceptHeader, @RequestBody PlayerRequest playerRequest) {
        Player player = new Player();
        player.setName(playerRequest.getName());
        player.setRating(playerRequest.getRating());
        player.setFavoriteCharacterName(playerRequest.getFavoriteCharacterName());
        playerService.addPlayer(player);
        return Helper.response(player,acceptHeader,"/players.xslt",Player.class);
    }

    @PutMapping
    public ResponseEntity<Object> updatePlayer(@RequestHeader("Accept") String acceptHeader, @RequestBody PlayerRequest playerRequest) {
        Player player = playerService.findPlayer(playerRequest.getPlayerId());
        if(player==null){
            return ResponseEntity.status(404).body("Game not found");
        }
        player.setName(playerRequest.getName());
        player.setRating(playerRequest.getRating());
        player.setFavoriteCharacterName(playerRequest.getFavoriteCharacterName());
        playerService.updatePlayer(player);

        return Helper.response(player,acceptHeader,"/players.xslt",Player.class);
    }

    @DeleteMapping
    public ResponseEntity<Object> deletePlayer(@RequestParam("id") Integer playerId, @RequestHeader("Accept") String acceptHeader) {
        Player player = playerService.findPlayer(playerId);
        if(player==null){
            return ResponseEntity.status(404).body("Game not found");
        }
        playerService.removePlayer(playerId);
        return Helper.response(player,acceptHeader,"/players.xslt", Player.class);
    }

}
