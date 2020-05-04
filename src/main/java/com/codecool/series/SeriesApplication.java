package com.codecool.series;

import com.codecool.series.model.Genre;
import com.codecool.series.model.Series;
import com.codecool.series.model.Status;
import com.codecool.series.service.InitDataProviderService;
import lombok.AllArgsConstructor;
import org.assertj.core.util.Lists;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class SeriesApplication {

    private InitDataProviderService initDataProvider;

    public static void main(String[] args) {
        SpringApplication.run(SeriesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> initDataProvider.setInitialData();
    }
}
