package com.codecool.series.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private LocalDate premiered;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Singular
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST})
    private List<Season> seasons;
    @Singular
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Genre> genres;
    @Transient
    private int numberOfSeasons;
}
