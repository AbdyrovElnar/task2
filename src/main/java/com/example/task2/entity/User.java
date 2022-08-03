package com.example.task2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;
}
