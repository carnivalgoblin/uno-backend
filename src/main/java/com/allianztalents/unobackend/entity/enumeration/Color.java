package com.allianztalents.unobackend.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    BLUE("Blue"),
    GREEN("Green"),
    YELLOW("Yellow"),
    RED("Red"),

    //WICHTIG: Black ist NUR der Initialwert, wird nicht als Farbe verwendet, da die Farbe bei der Erstellung der Karte festgelegt wird. 4+ Karten bekommen die Farbe die gewünscht wird.
    BLACK("Black");

    private final String colorName;
}
