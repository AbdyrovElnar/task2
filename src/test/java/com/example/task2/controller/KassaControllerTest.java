package com.example.task2.controller;

import com.example.task2.service.KassaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class KassaControllerTest {

    @Autowired
    KassaController kassaController;

    @MockBean
    KassaService kassaService;

}
