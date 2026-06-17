package com.sora.Sora_index.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.sora.Sora_index.Entity.SectorHistory;
import com.sora.Sora_index.service.SectorHistoryService;

@RestController
@RequestMapping("/api/sectors")
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
    
}