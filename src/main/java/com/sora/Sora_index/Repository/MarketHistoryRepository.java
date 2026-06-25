package com.sora.Sora_index.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sora.Sora_index.Entity.MarketHistory;

public interface MarketHistoryRepository
        extends JpaRepository<MarketHistory, Long> {

}