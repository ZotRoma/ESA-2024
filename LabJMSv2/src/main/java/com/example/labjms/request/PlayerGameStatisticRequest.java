package com.example.labjms.request;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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


    public void setPlayer(Integer PlayerId){
        this.PlayerId = PlayerId;
    }

    @Override
    public String toString() {
        return "PlayerGameStatisticRequest{" +
                "PlayerGameId=" + PlayerGameId +
                ", GameId=" + GameId +
                ", PlayerId=" + PlayerId +
                ", HeroName='" + HeroName + '\'' +
                ", Kills=" + Kills +
                ", Deaths=" + Deaths +
                ", Assists=" + Assists +
                ", LastHit=" + LastHit +
                '}';
    }
}
