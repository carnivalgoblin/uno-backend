package com.allianztalents.unobackend.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    BLAU("Blue"),
    GRÜN("Green"),
    GELB("Yellow"),
    ROT("Red");
    private final String colorName;
}
