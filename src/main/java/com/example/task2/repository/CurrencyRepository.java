package com.example.task2.repository;

import com.example.task2.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
}
