package com.sora.Sora_index.Entity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "sector_history")
public class SectorHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate tradeDate;

    private String sectorName;

    private Integer rankNo;

    private Integer score;

    private Double changeRate;

    // getter setter
}