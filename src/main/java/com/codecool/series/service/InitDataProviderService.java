package com.codecool.series.service;

import com.codecool.series.model.*;
import com.codecool.series.model.generated.episode.EpisodeDetails;
import com.codecool.series.model.generated.season.SeasonDetails;
import com.codecool.series.model.generated.show.ShowDetails;
import com.codecool.series.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InitDataProviderService {

    private SeriesRepository seriesRepository;
    private SeriesDataAPIService seriesDataAPIService;

    public void setInitialData() {
        final int[] SHOW_IDS = new int[] { 138, 3593, 30770 };
        for (int id : SHOW_IDS) {
           seriesRepository.save(buildSeriesInstanceById(id));
        }
    }

    private Series buildSeriesInstanceById(int id) {
        ShowDetails showDetails = seriesDataAPIService.getShowDetailsById(id);
        List<SeasonDetails> seasonDetails = seriesDataAPIService.getAllSeasonDetailsByShowId(id);

        Series series = Series.builder()
                .title(showDetails.getName())
                .premiered(LocalDate.parse(showDetails.getPremiered(), DateTimeFormatter.ISO_DATE))
                .status(Enum.valueOf(Status.class, showDetails.getStatus().toUpperCase()))
                .seasons(buildSeasonInstancesFrom(seasonDetails))
                .genres(getGenresInstancesFrom(showDetails.getGenres()))
                .build();

        for (Season season : series.getSeasons()) season.setSeries(series);

        return series;
    }

    private List<Genre> getGenresInstancesFrom(List<String> genres) {
        List<Genre> showGenres = new ArrayList<>();
        for (String genre : genres) {
            showGenres.add(Genre.getGenreBy(genre));
        }
        return showGenres;
    }

    private List<Season> buildSeasonInstancesFrom(List<SeasonDetails> seasonDetails) {
        List<Season> seasons = new ArrayList<>();
        for (SeasonDetails seasonDetail : seasonDetails) {
            List<EpisodeDetails> episodeDetails = seriesDataAPIService.getAllEpisodeDetailsBySeasonURL(
                    seasonDetail.getLinks().getSelf().getHref()
            );
            List<Episode> episodes = buildAllEpisodeInstancesFrom(episodeDetails);

            Season season = Season.builder()
                    .number(seasonDetail.getNumber())
                    .premiereDate(
                            seasonDetail.getPremiereDate() != null ?
                                    LocalDate.parse(seasonDetail.getPremiereDate(), DateTimeFormatter.ISO_DATE) : null
                    )
                    .endDate(
                            seasonDetail.getEndDate() != null ?
                                    LocalDate.parse(seasonDetail.getEndDate(), DateTimeFormatter.ISO_DATE) : null
                    )
                    .episodes(episodes)
                    .build();

            for (Episode episode : season.getEpisodes()) episode.setSeason(season);

            seasons.add(season);
        }
        return seasons;
    }

    private List<Episode> buildAllEpisodeInstancesFrom(List<EpisodeDetails> episodeDetails) {
        List<Episode> episodes = new ArrayList<>();

        for (EpisodeDetails episodeDetail : episodeDetails) {
            Episode episode = Episode.builder()
                    .number(episodeDetail.getNumber())
                    .title(episodeDetail.getName())
                    .runtime(episodeDetail.getRuntime())
                    .build();

            episodes.add(episode);
        }

        return episodes;
    }
}
