package com.codecool.series.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Genre {

    DRAMA("Drama"),
    SCIFI("Science-Fiction"),
    THRILLER("Thriller"),
    MYSTERY("Mystery");

    private String apiName;

    private static final Map<String, Genre> ENUM_MAP = setupEnumMap();
    private static Map<String, Genre> setupEnumMap() {
        Map<String, Genre> map = new HashMap<>();
        for (Genre genre : Genre.values()) {
            map.put(genre.getApiName(), genre);
        }
        return map;
    }

    public static Genre getGenreBy(String apiName) {
        return Genre.ENUM_MAP.get(apiName);
    }

}
