package com.sora.Sora_index.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sora.Sora_index.Entity.SectorHistory;
import com.sora.Sora_index.Repository.SectorHistoryRepository;
import java.util.Optional;

@Service
public class SectorHistoryService {

    private final SectorHistoryRepository repository;

    public SectorHistoryService(
            SectorHistoryRepository repository) {

        this.repository = repository;
    }

    public SectorHistory save(
            SectorHistory sectorHistory) {

        return repository.save(sectorHistory);
    }

    public List<SectorHistory> findAll() {
    return repository.findAll();
    }

    public Optional<SectorHistory> findById(Long id) {
    return repository.findById(id);
    }
}