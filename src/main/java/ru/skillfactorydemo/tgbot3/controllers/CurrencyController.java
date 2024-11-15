package ru.skillfactorydemo.tgbot3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skillfactorydemo.tgbot3.dto.ValuteCursOnDate;
import ru.skillfactorydemo.tgbot3.service.CentralRussianBankService;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import ru.skillfactorydemo.tgbot3.service.StatsService;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatsService statsService;

    @GetMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getCurrency/{code}")
    @Operation(summary = "Получение курса определенной валюты на текущий день",
            description = "По коду, например USD/EUR/CNY и т.п.")
    public ValuteCursOnDate getCourseForCurrency(@PathVariable String code) throws Exception {
        return centralRussianBankService.getCourseForCurrency(code);
    }

    @GetMapping("/getStats")
    @Operation(summary = "Получение количества пополнений, превышающих определённую сумму")
    public int getStatAboutIncomes(@RequestParam (value = "amount") BigDecimal amount){
        return statsService.getCountOfIncomesThatGreater(amount);
    }
}
