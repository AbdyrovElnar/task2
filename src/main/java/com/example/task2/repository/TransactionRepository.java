package com.example.task2.repository;

import com.example.task2.entity.Kassa;
import com.example.task2.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Optional<Transaction> findByUuid(String uniqCode);

    List<Transaction> findByFromKassaAndStatusLike(Kassa kassa, String status);

}
