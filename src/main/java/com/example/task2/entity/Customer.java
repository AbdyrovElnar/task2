package com.example.task2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
