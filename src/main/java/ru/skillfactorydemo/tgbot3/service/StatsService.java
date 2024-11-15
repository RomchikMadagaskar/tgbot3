package ru.skillfactorydemo.tgbot3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactorydemo.tgbot3.repository.StatsRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StatsService {
    public final StatsRepository statsRepository;

    public int getCountOfIncomesThatGreater(BigDecimal amount) {
        return statsRepository.getCountOfIncomesThatGreaterThan(amount);
    }

}
