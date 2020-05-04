package com.codecool.series.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;
    private int number;
    @ManyToOne
    private Series series;
    private LocalDate premiereDate;
    private LocalDate endDate;
    @Singular
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST})
    private List<Episode> episodes;

}
