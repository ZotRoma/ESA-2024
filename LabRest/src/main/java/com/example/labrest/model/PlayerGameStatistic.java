package com.example.labrest.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "player_game_statistic")
@XmlRootElement(name = "playerGameStatistic")
@XmlType(propOrder = {"playerGameId","game","player", "heroName", "kills", "deaths", "assists", "lastHit"})
public class PlayerGameStatistic {
    private Integer PlayerGameId;
    private Game Game;
    private Player Player;
    private String HeroName;
    private Integer Kills;
    private Integer Deaths;
    private Integer Assists;
    private Integer LastHit;
    //можно еще много описывать, но я остановлюсь на этом (страшно описывать больше логики)

    public PlayerGameStatistic(){}
    public PlayerGameStatistic(Game Game, Player Player, String HeroName, Integer Kills, Integer Deaths, Integer Assists, Integer LastHit) {
        this.Game = Game;
        this.Player = Player;
        this.HeroName = HeroName;
        this.Kills = Kills;
        this.Deaths = Deaths;
        this.Assists = Assists;
        this.LastHit = LastHit;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_game_id")
    @XmlElement
    public Integer getPlayerGameId(){
        return PlayerGameId;
    }
    public void setPlayerGameId(Integer playerGameId){
        PlayerGameId = playerGameId;
    }

    @ManyToOne
    @JoinColumn(name = "game")
    @XmlElement
    public Game getGame(){
        return this.Game;
    }
    public void setGame(Game game){
        this.Game = game;
    }

    @ManyToOne
    @JoinColumn(name = "player")
    @XmlElement
    public Player getPlayer(){
        return this.Player;
    }
    public void setPlayer(Player player){
        this.Player = player;
    }
    @Column(name = "hero_name")
    @XmlElement
    public String getHeroName(){ return HeroName; }
    public void setHeroName(String HeroName){ this.HeroName = HeroName; }
    @Column(name = "kills")
    @XmlElement
    public Integer getKills(){ return Kills; }
    public void setKills(Integer Kills){ this.Kills = Kills; }
    @Column(name = "deaths")
    @XmlElement
    public Integer getDeaths(){ return Deaths; }
    public void setDeaths(Integer Deaths){ this.Deaths = Deaths; }
    @Column(name = "assists")
    @XmlElement
    public Integer getAssists(){ return Assists; }
    public void setAssists(Integer Assists){ this.Assists = Assists; }
    @Column(name = "last_hit")
    @XmlElement
    public Integer getLastHit(){ return LastHit; }
    public void setLastHit(Integer LastHit){ this.LastHit = LastHit; }

}
