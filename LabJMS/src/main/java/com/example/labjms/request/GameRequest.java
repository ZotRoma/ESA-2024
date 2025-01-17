package com.example.labjms.request;



import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gameRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameRequest {
    @JsonProperty("gameId")
    private Integer gameId;

    @JsonProperty("numberKillsRadiant")
    private Integer numberKillsRadiant;

    @JsonProperty("numberKillsDire")
    private Integer numberKillsDire;

    @JsonProperty("whoWin")
    private String whoWin;

    @JsonProperty("time")
    private Integer time;

    public GameRequest() {}

    // Геттеры и сеттеры
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getNumberKillsRadiant() {
        return numberKillsRadiant;
    }

    public void setNumberKillsRadiant(Integer numberKillsRadiant) {
        this.numberKillsRadiant = numberKillsRadiant;
    }

    public Integer getNumberKillsDire() {
        return numberKillsDire;
    }

    public void setNumberKillsDire(Integer numberKillsDire) {
        this.numberKillsDire = numberKillsDire;
    }

    public String getWhoWin() {
        return whoWin;
    }

    public void setWhoWin(String whoWin) {
        this.whoWin = whoWin;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}