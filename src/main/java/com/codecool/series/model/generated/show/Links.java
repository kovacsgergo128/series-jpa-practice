package com.codecool.series.model.generated.show;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links{

	@JsonProperty("self")
	private Self self;

	@JsonProperty("previousepisode")
	private Previousepisode previousepisode;

	public Self getSelf(){
		return self;
	}

	public Previousepisode getPreviousepisode(){
		return previousepisode;
	}
}