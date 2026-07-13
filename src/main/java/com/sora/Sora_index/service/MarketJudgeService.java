package com.sora.Sora_index.service;

import org.springframework.stereotype.Service;

import com.sora.Sora_index.dto.MarketJudgeDto;

@Service
public class MarketJudgeService {

    public MarketJudgeDto judge() {

        // 仮データ
        double changeRate = 1.25;

        if (changeRate >= 2) {
            return new MarketJudgeDto(5, "超強気", changeRate);
        } else if (changeRate >= 1) {
            return new MarketJudgeDto(4, "強気", changeRate);
        } else if (changeRate >= 0) {
            return new MarketJudgeDto(3, "中立", changeRate);
        } else if (changeRate >= -1) {
            return new MarketJudgeDto(2, "弱気", changeRate);
        } else {
            return new MarketJudgeDto(1, "超弱気", changeRate);
        }
    }
}