package com.example.task2.service;

import com.example.task2.dto.TransactionDTO;
import com.example.task2.entity.Status;
import com.example.task2.entity.Transaction;
import com.example.task2.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository trRepo;

    public void saveTransaction(TransactionDTO trDto) {
        Transaction tr = Transaction.builder()
                .sum(trDto.getSum())
                .fromKassa(trDto.getFromKassa())
                .toKassa(trDto.getToKassa())
                .currency(trDto.getCurrency())
                .fromCustomer(trDto.getFromCustomer())
                .fromPhoneNumber(trDto.getFromPhoneNumber().toString())
                .toCustomer(trDto.getToCustomer())
                .toPhoneNumber(trDto.getToPhoneNumber().toString())
                .comment(trDto.getComment())
                .uuid(UUID.randomUUID().toString())
                .status(Status.CREATED.toString())
                .date(LocalDateTime.now())
                .build();
        trRepo.save(tr);
    }

    public TransactionDTO checkCode(String uniqCode) {

        Optional<Transaction> tr = trRepo.findByUuid(uniqCode);

        if (tr.isPresent()) {
            return TransactionDTO.builder()
                    .fromKassa(tr.get().getFromKassa())
                    .fromCustomer(tr.get().getFromCustomer())
                    .toKassa(tr.get().getToKassa())
                    .toCustomer(tr.get().getToCustomer())
                    .date(tr.get().getDate())
                    .currency(tr.get().getCurrency())
                    .fromPhoneNumber(tr.get().getFromPhoneNumber())
                    .toPhoneNumber(tr.get().getToPhoneNumber())
                    .sum(tr.get().getSum())
                    .comment(tr.get().getComment())
                    .status(tr.get().getStatus())
                    .id(tr.get().getId())
                    .build();
        }
        return null;
    }

    public void getMoney(Long transferId) {
        Optional<Transaction> tr = trRepo.findById(transferId);
        if (tr.isPresent()) {
            tr.get().setStatus(Status.ISSUED.toString());
            trRepo.save(tr.get());
        }
    }
}
