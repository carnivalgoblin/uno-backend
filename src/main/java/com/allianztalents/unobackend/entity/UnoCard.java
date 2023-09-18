package com.allianztalents.unobackend.entity;

import com.allianztalents.unobackend.entity.enumeration.Color;
import com.allianztalents.unobackend.entity.enumeration.Numeration;
import com.allianztalents.unobackend.entity.enumeration.SpecialEffect;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class UnoCard {

    @Id
    private Long id;
    private Numeration numeration;
    private Color color;
    private SpecialEffect specialEffect;
    private boolean played = false;
    private String pictureString;

    public UnoCard(Color color, Numeration numeration) {
        this.color = color;
        this.numeration = numeration;
        this.specialEffect = null;
        this.pictureString = color.name() + "-" + numeration.name();
    }

    public UnoCard(Color color, SpecialEffect specialEffect) {
        this.color = color;
        this.numeration = Numeration.SPECIAL_EFFECT;
        this.specialEffect = specialEffect;
        this.pictureString = color.name() + "-" + specialEffect.name();
    }

}
