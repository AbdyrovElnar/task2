package com.example.task2.controller;

import com.example.task2.service.KassaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kassa")
@RequiredArgsConstructor
public class KassaController {
private final KassaService kassaService;
    @GetMapping("/create")
    public String createNewKassa() {
        return "createKassa";
    }

    @PostMapping("/create")
    public String createNewKassaPOST(@RequestParam("kassaName") String kassaName){
        kassaService.addNewKassa(kassaName);
        return "successfully_created";
    }

}
