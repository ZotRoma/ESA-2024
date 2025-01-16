package com.example.labspring.model;

import jakarta.persistence.*;

@Entity
@Table(name="player_profiler")
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
    public Integer getPlayerId(){
        return PlayerId;
    }
    public void setPlayerId(Integer PlayerId){
        this.PlayerId = PlayerId;
    }
    @Column(name = "rating")
    public Integer getRating(){
        return Rating;
    }
    public void setRating(Integer Rating){
        this.Rating = Rating;
    }

    @Column(name = "favorite_character_name")
    public String getFavoriteCharacterName(){
        return FavoriteCharacterName;
    }
    public void setFavoriteCharacterName(String FavoriteCharacterName){
        this.FavoriteCharacterName = FavoriteCharacterName;
    }

    @Column(name = "name")
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
}
