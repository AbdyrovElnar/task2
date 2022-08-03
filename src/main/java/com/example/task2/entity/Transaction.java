package com.example.task2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int summ;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "fromCustomer_id")
    private Customer fromCustomer;

    private String fromPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "toCustomer_id")
    private Customer toCustomer;

    private String toPhoneNumber;

    private String comment;

    private String uuid = UUID.randomUUID().toString();

}
