package com.example.labrest.request;

import com.example.labrest.model.Game;
import com.example.labrest.model.Player;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="playerGameStatisticRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerGameStatisticRequest {
    @JsonbProperty("playerGameId")
    private Integer PlayerGameId;
    @JsonbProperty("gameId")
    private Integer GameId;
    @JsonbProperty("playerId")
    private Integer PlayerId;
    @JsonbProperty("heroName")
    private String HeroName;
    @JsonbProperty("kills")
    private Integer Kills;
    @JsonbProperty("deaths")
    private Integer Deaths;
    @JsonbProperty("assists")
    private Integer Assists;
    @JsonbProperty("lastHit")
    private Integer LastHit;

    public PlayerGameStatisticRequest(){}

    public Integer getPlayerGameId(){
        return PlayerGameId;
    }
    public void setPlayerGameId(Integer playerGameId){
        PlayerGameId = playerGameId;
    }


    public Integer getGameId(){
        return this.GameId;
    }
    public void setGameId(Integer GameId){
        this.GameId = GameId;
    }

    public Integer getPlayerId(){
        return this.PlayerId;
    }
    public void setPlayer(Integer PlayerId){
        this.PlayerId = PlayerId;
    }

    public String getHeroName(){ return HeroName; }
    public void setHeroName(String HeroName){ this.HeroName = HeroName; }

    public Integer getKills(){ return Kills; }
    public void setKills(Integer Kills){ this.Kills = Kills; }

    public Integer getDeaths(){ return Deaths; }
    public void setDeaths(Integer Deaths){ this.Deaths = Deaths; }

    public Integer getAssists(){ return Assists; }
    public void setAssists(Integer Assists){ this.Assists = Assists; }

    public Integer getLastHit(){ return LastHit; }
    public void setLastHit(Integer LastHit){ this.LastHit = LastHit; }
}
