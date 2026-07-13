package com.sora.Sora_index.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sora.Sora_index.Entity.MarketHistory;
import com.sora.Sora_index.service.MarketHistoryService;

@RestController
@RequestMapping("/api/market")
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<MarketHistory> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}