package com.codecool.series.model.generated.season;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeasonDetails{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("number")
	private int number;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("premiereDate")
	private String premiereDate;

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("webChannel")
	private Object webChannel;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("name")
	private String name;

	@JsonProperty("episodeOrder")
	private int episodeOrder;

	@JsonProperty("id")
	private int id;

	@JsonProperty("url")
	private String url;

	@JsonProperty("network")
	private Network network;

	public String getSummary(){
		return summary;
	}

	public int getNumber(){
		return number;
	}

	public Image getImage(){
		return image;
	}

	public String getPremiereDate(){
		return premiereDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public Object getWebChannel(){
		return webChannel;
	}

	public Links getLinks(){
		return links;
	}

	public String getName(){
		return name;
	}

	public int getEpisodeOrder(){
		return episodeOrder;
	}

	public int getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}

	public Network getNetwork(){
		return network;
	}
}