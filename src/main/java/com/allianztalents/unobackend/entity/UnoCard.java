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

    public UnoCard(Color color, Numeration numeration) {
        this.color = color;
        this.numeration = numeration;
        this.specialEffect = null;
    }

    public UnoCard(Color color, SpecialEffect specialEffect) {
        this.color = color;
        this.numeration = Numeration.SPECIAL_EFFECT;
        this.specialEffect = specialEffect;
    }

}
