package com.allianztalents.unobackend.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SpecialEffect {
    SKIP("Skip"),
    DRAW_TWO("Draw 2+"),
    DRAW_FOUR_COLOR_WISH("Draw 4+ Color Wish"),
    COLOR_WISH("Color Wish"),
    REVERSE("Reverse");

    private final String description;

    public String getDescription() {
        return description;
    }
}
