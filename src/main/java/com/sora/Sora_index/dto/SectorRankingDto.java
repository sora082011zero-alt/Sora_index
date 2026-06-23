package com.sora.Sora_index.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SectorRankingDto {

    private Integer rank;

    private String sectorName;

    private Integer totalScore;
}