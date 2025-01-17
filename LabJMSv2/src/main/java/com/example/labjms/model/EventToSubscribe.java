package com.example.labjms.model;


import com.example.labjms.enums.ChangeTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "events_to_subscribe")
public class EventToSubscribe {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "eventType")
    private ChangeTypeEnum eventType;
}
