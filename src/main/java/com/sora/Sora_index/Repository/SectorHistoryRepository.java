package com.sora.Sora_index.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sora.Sora_index.Entity.SectorHistory;

public interface SectorHistoryRepository
        extends JpaRepository<SectorHistory, Long> {

    List<SectorHistory> findBySectorName(String sectorName);

    List<SectorHistory> findByTradeDate(LocalDate tradeDate);

    @Query("""
        SELECT COALESCE(SUM(s.score), 0)
        FROM SectorHistory s
        WHERE s.sectorName = :sectorName
    """)
    Integer getTotalScore(String sectorName);

    @Query("""
        SELECT s.sectorName, SUM(s.score)
        FROM SectorHistory s
        GROUP BY s.sectorName
        ORDER BY SUM(s.score) DESC
    """)
    List<Object[]> getSectorRanking();
    
}