package com.allianztalents.unobackend.entity;

import com.allianztalents.unobackend.entity.enumeration.Color;
import com.allianztalents.unobackend.entity.enumeration.Numeration;
import com.allianztalents.unobackend.entity.enumeration.SpecialEffect;

public class UnoCard {
    private int id;
    private Numeration numeration;
    private Color color;
    private SpecialEffect spezialEffect;

    public UnoCard(Color color, Numeration numeration) {
        this.color = color;
        this.numeration = numeration;
        this.spezialEffect = null;
    }

    public UnoCard(Color color, SpecialEffect spezialEffect) {
        this.color = color;
        this.numeration = Numeration.SPECIAL_EFFECT;
        this.spezialEffect = spezialEffect;
    }

}
