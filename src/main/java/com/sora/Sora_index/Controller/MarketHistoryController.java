package com.sora.Sora_index.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sora.Sora_index.Entity.MarketHistory;
import com.sora.Sora_index.service.MarketHistoryService;

@RestController
@RequestMapping("/api/market")
public class MarketHistoryController {

    private final MarketHistoryService service;

    public MarketHistoryController(MarketHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<MarketHistory> findAll() {
        return service.findAll();
    }

    @PostMapping
    public MarketHistory create(@RequestBody MarketHistory marketHistory) {
        return service.save(marketHistory);
    }

    @GetMapping("/{id}")
    public MarketHistory findById(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("MarketHistory not found"));
    }
}