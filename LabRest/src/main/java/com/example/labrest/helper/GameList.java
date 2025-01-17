package com.example.labrest.helper;

import com.example.labrest.model.Game;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class GameList {
    private List<Game> games;

    @XmlElement
    public List<Game> getGames() {return games;}
    public void setGames(List<Game> games) {this.games = games;}
}
