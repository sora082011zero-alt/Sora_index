package com.sora.Sora_index.Controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import com.sora.Sora_index.Entity.SectorHistory;
import com.sora.Sora_index.service.SectorHistoryService;
import com.sora.Sora_index.dto.SectorRankingDto;

@RestController
@RequestMapping("/api/sectors")
@CrossOrigin(origins = "http://localhost:5173")
public class SectorHistoryController {

    private final SectorHistoryService service;

    public SectorHistoryController(SectorHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<SectorHistory> findAll() {
        return service.findAll();
    }

    @PostMapping
    public SectorHistory create(@RequestBody SectorHistory sectorHistory) {
        return service.save(sectorHistory);
    }

    @GetMapping("/{id}")
    public SectorHistory findById(@PathVariable Long id) {
    return service.findById(id)
    .orElseThrow(() -> new RuntimeException("SectorHistory not found"));
    }

    @GetMapping("/name/{sectorName}")
    public List<SectorHistory> findBySectorName(@PathVariable String sectorName) {
    return service.findBySectorName(sectorName);
    }

    @GetMapping("/date/{tradeDate}")
    public List<SectorHistory> findByTradeDate(
        @PathVariable LocalDate tradeDate) {
            return service.findByTradeDate(tradeDate);
        }

    @GetMapping("/score/{sectorName}")
    public Integer getTotalScore(
        @PathVariable String sectorName) {
            return service.getTotalScore(sectorName);
        }
    
    @GetMapping("/ranking")
    public List<SectorRankingDto> getSectorRanking() {
        return service.getSectorRanking();
    }
}