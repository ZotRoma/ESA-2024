package com.example.labjms.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name="game_profiler")
@XmlRootElement(name = "game")
@XmlType(propOrder = {"gameId", "numberKillsRadiant", "numberKillsDire", "whoWin", "time"})
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
    @XmlElement
    public Integer getGameId(){
        return GameId;
    }
    public void setGameId(Integer GameId){
        this.GameId = GameId;
    }
    @Column(name = "number_kills_radiant")
    @XmlElement
    public Integer getNumberKillsRadiant(){
        return NumberKillsRadiant;
    }
    public void setNumberKillsRadiant(Integer NumberKillsRadiant){
        this.NumberKillsRadiant = NumberKillsRadiant;
    }

    @Column(name = "number_kills_dire")
    @XmlElement
    public Integer getNumberKillsDire(){
        return NumberKillsDire;
    }
    public void setNumberKillsDire(Integer NumberKillsDire){
        this.NumberKillsDire = NumberKillsDire;
    }

    @Column(name = "who_win")
    @XmlElement
    public String getWhoWin(){
        return WhoWin;
    }
    public void setWhoWin(String WhoWin){
        this.WhoWin = WhoWin;
    }

    @Column(name = "time")
    @XmlElement
    public Integer getTime(){
        return Time;
    }
    public void setTime(Integer Time){
        this.Time = Time;
    }
}
