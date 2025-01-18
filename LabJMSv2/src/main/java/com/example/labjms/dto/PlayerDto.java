package com.example.labjms.dto;

import com.example.labjms.model.Player;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PlayerDto implements Serializable {
    private Integer PlayerId;
    private Integer Rating;
    private String Name;
    private String FavoriteCharacterName;

    public Player toEntity() {
        return new Player(this.Rating, this.FavoriteCharacterName, this.Name);
    }
}
