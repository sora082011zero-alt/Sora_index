package com.sora.Sora_index.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sora.Sora_index.Entity.SectorIndexHistory;
import com.sora.Sora_index.service.SectorIndexHistoryService;

@RestController
@RequestMapping("/api/sector-index")
@CrossOrigin(origins = "http://localhost:5173")
public class SectorIndexHistoryController {

    private final SectorIndexHistoryService service;

    public SectorIndexHistoryController(SectorIndexHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<SectorIndexHistory> findAll() {
        return service.findAll();
    }

    @PostMapping
    public SectorIndexHistory create(@RequestBody SectorIndexHistory history) {
        return service.save(history);
    }

    @GetMapping("/{id}")
    public SectorIndexHistory findById(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("SectorIndexHistory not found"));
    }

    @GetMapping("/name/{sectorName}")
    public List<SectorIndexHistory> findBySectorName(@PathVariable String sectorName) {
        return service.findBySectorName(sectorName);
    }
}