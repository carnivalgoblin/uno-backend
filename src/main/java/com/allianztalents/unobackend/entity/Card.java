package com.allianztalents.unobackend.entity;

import com.allianztalents.unobackend.entity.enumeration.Color;
import com.allianztalents.unobackend.entity.enumeration.Numeration;
import com.allianztalents.unobackend.entity.enumeration.SpecialEffect;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Numeration numeration;

    @Enumerated(value = EnumType.STRING)
    private Color color;

    @Enumerated(value = EnumType.STRING)
    private SpecialEffect specialEffect;

    private boolean played = false;

    private String pictureString;

    public Card(Color color, Numeration numeration) {
        this.color = color;
        this.numeration = numeration;
        this.specialEffect = null;
        this.pictureString = color.name() + "-" + numeration.name();
    }

    public Card(Color color, SpecialEffect specialEffect) {
        this.color = color;
        this.numeration = Numeration.SPECIAL_EFFECT;
        this.specialEffect = specialEffect;
        this.pictureString = color.name() + "-" + specialEffect.name();
    }

    public Card(Card card){
        this.id = card.getId();
        this.numeration = card.getNumeration();
        this.color = card.getColor();
        this.specialEffect = card.getSpecialEffect();
        this.played = card.isPlayed();
        this.pictureString = card.getPictureString();
    }

}
