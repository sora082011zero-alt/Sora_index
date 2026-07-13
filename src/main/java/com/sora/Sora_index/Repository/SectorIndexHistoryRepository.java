package com.sora.Sora_index.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sora.Sora_index.Entity.SectorIndexHistory;

public interface SectorIndexHistoryRepository
        extends JpaRepository<SectorIndexHistory, Long> {

    List<SectorIndexHistory> findBySectorName(String sectorName);
}