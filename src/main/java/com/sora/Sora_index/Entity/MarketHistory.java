package com.sora.Sora_index.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "market_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate tradeDate;

    private BigDecimal nikkei225;

    private BigDecimal topix;
}