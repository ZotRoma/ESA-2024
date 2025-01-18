package com.example.labjms.helper;

import com.example.labjms.model.Player;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class PlayerList {
    private List<Player> players;

    @XmlElement
    public List<Player> getPlayers() {return players;}
    public void setPlayers(List<Player> players) {this.players = players;}
}
