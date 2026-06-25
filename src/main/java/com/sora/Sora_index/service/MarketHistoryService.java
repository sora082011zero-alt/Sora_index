package com.sora.Sora_index.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sora.Sora_index.Entity.MarketHistory;
import com.sora.Sora_index.Repository.MarketHistoryRepository;

@Service
public class MarketHistoryService {

    private final MarketHistoryRepository repository;

    public MarketHistoryService(MarketHistoryRepository repository) {
        this.repository = repository;
    }

    public List<MarketHistory> findAll() {
        return repository.findAll();
    }

    public MarketHistory save(MarketHistory marketHistory) {
        return repository.save(marketHistory);
    }

    public Optional<MarketHistory> findById(Long id) {
        return repository.findById(id);
    }
}