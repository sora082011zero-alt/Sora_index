package com.sora.Sora_index.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sector_index_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectorIndexHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate tradeDate;

    private String sectorName;

    private BigDecimal sectorIndex;

    private BigDecimal changeRate;
}