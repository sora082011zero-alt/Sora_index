package com.sora.Sora_index.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MarketJudgeDto {

    private int score;
    private String level;
    private double changeRate;

}