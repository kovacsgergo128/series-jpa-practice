package com.codecool.series.service;

import com.codecool.series.model.generated.episode.EpisodeDetails;
import com.codecool.series.model.generated.season.SeasonDetails;
import com.codecool.series.model.generated.show.ShowDetails;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SeriesDataAPIService {

    public ShowDetails getShowDetailsById(int id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<ShowDetails> showDetailsResponseEntity = template.exchange(
                "http://api.tvmaze.com/shows/" + id,
                HttpMethod.GET,
                null,
                ShowDetails.class);

        return showDetailsResponseEntity.getBody();
    }

    public List<SeasonDetails> getAllSeasonDetailsByShowId(int id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<SeasonDetails[]> seasonDetailsResponseEntity = template.exchange(
                "http://api.tvmaze.com/shows/" + id + "/seasons",
                HttpMethod.GET,
                null,
                SeasonDetails[].class);

        return Arrays.asList(Objects.requireNonNull(seasonDetailsResponseEntity.getBody()));
    }

    public List<EpisodeDetails> getAllEpisodeDetailsBySeasonURL(String url) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<EpisodeDetails[]> episodeDetailsResponseEntity = template.exchange(
                url + "/episodes",
                HttpMethod.GET,
                null,
                EpisodeDetails[].class);

        return Arrays.asList(Objects.requireNonNull(episodeDetailsResponseEntity.getBody()));
    }
}
