package com.allianztalents.unobackend.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    BLAU("Blau"),
    GRÜN("Grün"),
    GELB("Gelb"),
    ROT("Rot");
    private final String colorName;
}
