package com.example.labjms.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name="player_profiler")
@XmlRootElement(name = "player")
@XmlType(propOrder = {"playerId", "rating", "favoriteCharacterName", "name"})
public class Player {
    private Integer PlayerId;
    private Integer Rating;
    private String FavoriteCharacterName;
    private String Name;
    public Player(){}
    public Player(Integer Rating, String FavoriteCharacterName, String Name){
        this.Rating = Rating;
        this.FavoriteCharacterName = FavoriteCharacterName;
        this.Name = Name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    @XmlElement
    public Integer getPlayerId(){
        return PlayerId;
    }
    public void setPlayerId(Integer PlayerId){
        this.PlayerId = PlayerId;
    }
    @Column(name = "rating")
    @XmlElement
    public Integer getRating(){
        return Rating;
    }
    public void setRating(Integer Rating){
        this.Rating = Rating;
    }

    @Column(name = "favorite_character_name")
    @XmlElement
    public String getFavoriteCharacterName(){
        return FavoriteCharacterName;
    }
    public void setFavoriteCharacterName(String FavoriteCharacterName){
        this.FavoriteCharacterName = FavoriteCharacterName;
    }

    @Column(name = "name")
    @XmlElement
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
}
