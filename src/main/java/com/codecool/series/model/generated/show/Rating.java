package com.codecool.series.model.generated.show;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating{

	@JsonProperty("average")
	private double average;

	public double getAverage(){
		return average;
	}
}