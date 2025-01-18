package com.example.labjms.request;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlRootElement(name="playerRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerRequest {
    @JsonbProperty("playerId")
    private Integer PlayerId;
    @JsonbProperty("rating")
    private Integer Rating;
    @JsonbProperty("favoriteCharacterName")
    private String FavoriteCharacterName;
    @JsonbProperty("name")
    private String Name;

    public PlayerRequest(){}

    @Override
    public String toString() {
        return "PlayerRequest{" +
                "PlayerId=" + PlayerId +
                ", Rating=" + Rating +
                ", FavoriteCharacterName='" + FavoriteCharacterName + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
