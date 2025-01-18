package com.example.labjms.request;



import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlRootElement(name = "gameRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameRequest {
    // Геттеры и сеттеры
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

    @Override
    public String toString() {
        return "GameRequest{" +
                "gameId=" + gameId +
                ", numberKillsRadiant=" + numberKillsRadiant +
                ", numberKillsDire=" + numberKillsDire +
                ", whoWin='" + whoWin + '\'' +
                ", time=" + time +
                '}';
    }
}