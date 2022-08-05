package com.example.task2.controller;

import com.example.task2.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    @GetMapping("/create")
    public String createNewCurrency() {
        return "createCurrency";
    }

    @PostMapping("/create")
    public String createNewCurrencyPOST(@RequestParam("currencyName") String currencyName){
        currencyService.addNewCurrency(currencyName);
        return "successfully_created";
    }

}
