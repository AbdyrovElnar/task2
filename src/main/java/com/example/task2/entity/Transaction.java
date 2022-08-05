package com.example.task2.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    private int sum;

    @ManyToOne
    @JoinColumn(name = "from_kassa_id")
    private Kassa fromKassa;

    @ManyToOne
    @JoinColumn(name = "to_kassa_id")
    private Kassa toKassa;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private String fromCustomer;

    private String fromPhoneNumber;

    private String toCustomer;

    private String toPhoneNumber;

    private String comment;

    private String uuid = UUID.randomUUID().toString();

    private String status;

    private LocalDateTime date;

}
