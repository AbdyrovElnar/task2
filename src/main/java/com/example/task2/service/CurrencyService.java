package com.example.task2.service;

import com.example.task2.entity.Currency;
import com.example.task2.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
private final CurrencyRepository currRepo;
    public List<Currency> getListOfCurrency(){
        return currRepo.findAll();
    }

    public void addNewCurrency(String currencyName){
        Currency currency = Currency.builder()
                .name(currencyName)
                .build();
        currRepo.save(currency);
    }
}
