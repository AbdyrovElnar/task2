package com.example.task2.controller;

import com.example.task2.service.KassaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
