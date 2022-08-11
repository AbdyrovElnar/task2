package com.example.task2.service;

import com.example.task2.dto.TransactionDTO;
import com.example.task2.entity.Currency;
import com.example.task2.entity.Kassa;
import com.example.task2.entity.Status;
import com.example.task2.entity.Transaction;
import com.example.task2.repository.TransactionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionServiceTest {

    @InjectMocks
    TransactionService transactionService;

    @Mock
    TransactionRepository trRepo;

    Transaction transaction;


    @BeforeEach
    void setupBeforeEach() {
        transaction = Transaction.builder()
                .id(1L)
                .sum(2000)
                .currency(Currency.builder().name("KGZ").build())
                .fromKassa(Kassa.builder()
                        .name("КассаА")
                        .build())
                .toKassa(Kassa.builder()
                        .name("КассаБ")
                        .build())
                .fromPhoneNumber("+996552902002")
                .toPhoneNumber("+996555302002")
                .fromCustomer("Абдыров Элнар")
                .toCustomer("Баширов Альфит")
                .comment("Альфит получит сумму")
                .uuid(UUID.randomUUID().toString())
                .status(Status.CREATED.toString())
                .date(LocalDateTime.now())
                .build();
    }

    @Test
    void saveTransaction() {
        when(trRepo.save(ArgumentMatchers.any(Transaction.class))).thenReturn(transaction);
        TransactionDTO created = transactionService.saveTransaction(TransactionDTO.from(transaction));
        Assertions.assertThat(transaction.getSum()).isEqualTo(created.getSum());
    }
}
