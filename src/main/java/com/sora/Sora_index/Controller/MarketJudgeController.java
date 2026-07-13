package com.sora.Sora_index.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sora.Sora_index.dto.MarketJudgeDto;
import com.sora.Sora_index.service.MarketJudgeService;

@RestController
@RequestMapping("/api/market/judge")
@CrossOrigin(origins = "http://localhost:5173")
public class MarketJudgeController {

    private final MarketJudgeService marketJudgeService;

    public MarketJudgeController(MarketJudgeService marketJudgeService) {
        this.marketJudgeService = marketJudgeService;
    }

    @GetMapping
    public MarketJudgeDto judge() {
        return marketJudgeService.judge();
    }
}