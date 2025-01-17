package com.example.labrest.helper;

import com.example.labrest.model.PlayerGameStatistic;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class PlayerGameStatisticList {
    private List<PlayerGameStatistic> playerGameStatisticList;
    @XmlElement
    public List<PlayerGameStatistic> getPlayerGameStatisticList() {return playerGameStatisticList;}
    public void setPlayerGameStatisticList(List<PlayerGameStatistic> playerGameStatisticList) {this.playerGameStatisticList = playerGameStatisticList;}

}
