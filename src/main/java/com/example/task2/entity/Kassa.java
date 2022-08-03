package com.example.task2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cashRegister")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Kassa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
