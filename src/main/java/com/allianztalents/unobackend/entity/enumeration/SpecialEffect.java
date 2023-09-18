package com.allianztalents.unobackend.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SpecialEffect {
    SKIP("Skip"),
    DRAW_TWO("Draw 2+"),
    DRAW_FOUR("Draw 4+"),
    COLOR_WISH("Color Wish"),
    REVERSE("Reverse");

    private final String description;

    public String getDescription() {
        return description;
    }
}
