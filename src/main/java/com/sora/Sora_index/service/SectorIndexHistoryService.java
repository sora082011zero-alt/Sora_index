package com.sora.Sora_index.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sora.Sora_index.Entity.SectorIndexHistory;
import com.sora.Sora_index.Repository.SectorIndexHistoryRepository;

@Service
public class SectorIndexHistoryService {

    private final SectorIndexHistoryRepository repository;

    public SectorIndexHistoryService(SectorIndexHistoryRepository repository) {
        this.repository = repository;
    }

    public List<SectorIndexHistory> findAll() {
        return repository.findAll();
    }

    public SectorIndexHistory save(SectorIndexHistory history) {
        return repository.save(history);
    }

    public Optional<SectorIndexHistory> findById(Long id) {
        return repository.findById(id);
    }

    public List<SectorIndexHistory> findBySectorName(String sectorName) {
    return repository.findBySectorName(sectorName);
    }
}