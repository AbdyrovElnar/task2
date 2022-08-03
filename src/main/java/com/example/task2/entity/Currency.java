package com.example.task2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
