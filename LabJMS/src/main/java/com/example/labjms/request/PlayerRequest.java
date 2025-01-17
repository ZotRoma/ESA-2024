package com.example.labjms.request;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

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

    public Integer getPlayerId(){
        return PlayerId;
    }
    public void setPlayerId(Integer PlayerId){
        this.PlayerId = PlayerId;
    }

    public Integer getRating(){
        return Rating;
    }
    public void setRating(Integer Rating){
        this.Rating = Rating;
    }

    public String getFavoriteCharacterName(){
        return FavoriteCharacterName;
    }
    public void setFavoriteCharacterName(String FavoriteCharacterName){
        this.FavoriteCharacterName = FavoriteCharacterName;
    }

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
}
