package com.example.task2.service;

import com.example.task2.entity.Kassa;
import com.example.task2.repository.KassaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KassaService {
private final KassaRepository kassaRepo;

public List<Kassa> getListOfKassa(){
    return kassaRepo.findAll();
}
}
