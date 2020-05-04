package com.codecool.series.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    ENDED("Ended"),
    RUNNING("Running");

    private String apiValue;
}
