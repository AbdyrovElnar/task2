package com.example.task2.dto;

import com.example.task2.entity.Currency;
import com.example.task2.entity.Kassa;
import com.example.task2.entity.Transaction;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TransactionDTO {

    private Long id;
    private int sum;
    private Kassa fromKassa;
    private Kassa toKassa;
    private Currency currency;
    private String fromCustomer;
    private String fromPhoneNumber;
    private String toCustomer;
    private String toPhoneNumber;
    private String comment;
    private LocalDateTime date;
    private String status;
    private String uuid;

    public static TransactionDTO from(Transaction transaction){
        return TransactionDTO.builder()
                .id(transaction.getId())
                .sum(transaction.getSum())
                .fromKassa(transaction.getFromKassa())
                .toKassa(transaction.getToKassa())
                .currency(transaction.getCurrency())
                .fromCustomer(transaction.getFromCustomer())
                .toCustomer(transaction.getToCustomer())
                .toPhoneNumber(transaction.getToPhoneNumber())
                .fromPhoneNumber(transaction.getFromPhoneNumber())
                .comment(transaction.getComment())
                .date(transaction.getDate())
                .status(transaction.getStatus())
                .uuid(transaction.getUuid())
                .build();
    }

}
