package com.example.labservlet.entities;

import jakarta.persistence.*;

@Entity
@Table(name="game_profiler")
public class Game {
    private Integer GameId;
    private Integer NumberKillsRadiant;
    private Integer NumberKillsDire;
    private String WhoWin;
    private Integer Time;

    public Game(){}
    public Game(Integer NumberKillsRadiant,
                Integer NumberKillsDire,
                String WhoWin,
                Integer Time){
        this.NumberKillsRadiant = NumberKillsRadiant;
        this.NumberKillsDire = NumberKillsDire;
        this.WhoWin = WhoWin;
        this.Time = Time;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    public Integer getGameId(){
        return GameId;
    }
    public void setGameId(Integer GameId){
        this.GameId = GameId;
    }
    @Column(name = "number_kills_radiant")
    public Integer getNumberKillsRadiant(){
        return NumberKillsRadiant;
    }
    public void setNumberKillsRadiant(Integer NumberKillsRadiant){
        this.NumberKillsRadiant = NumberKillsRadiant;
    }

    @Column(name = "number_kills_dire")
    public Integer getNumberKillsDire(){
        return NumberKillsDire;
    }
    public void setNumberKillsDire(Integer NumberKillsDire){
        this.NumberKillsDire = NumberKillsDire;
    }

    @Column(name = "who_win")
    public String getWhoWin(){
        return WhoWin;
    }
    public void setWhoWin(String WhoWin){
        this.WhoWin = WhoWin;
    }

    @Column(name = "time")
    public Integer getTime(){
        return Time;
    }
    public void setTime(Integer Time){
        this.Time = Time;
    }


}
