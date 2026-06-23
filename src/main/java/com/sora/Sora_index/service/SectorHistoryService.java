package com.sora.Sora_index.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sora.Sora_index.Entity.SectorHistory;
import com.sora.Sora_index.Repository.SectorHistoryRepository;
import java.util.Optional;
import com.sora.Sora_index.dto.SectorRankingDto;

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

    public List<SectorHistory> findBySectorName(String sectorName) {
    return repository.findBySectorName(sectorName);
    }

    public List<SectorHistory> findByTradeDate(LocalDate tradeDate) {
    return repository.findByTradeDate(tradeDate);
    }

    public Integer getTotalScore(String sectorName) {
    return repository.getTotalScore(sectorName);
    }
    
    public List<SectorRankingDto> getSectorRanking() {
        List<Object[]> result = repository.getSectorRanking();
        List<SectorRankingDto> ranking = new ArrayList<>();
        int rank = 1;
        for (Object[] row : result) {
            ranking.add(
                new SectorRankingDto(
                    rank++,
                    (String) row[0],
                    ((Number) row[1]).intValue()
                )
            );
        }
        return ranking;
    }

}