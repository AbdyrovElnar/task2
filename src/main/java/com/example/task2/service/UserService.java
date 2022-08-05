package com.example.task2.service;

import com.example.task2.dto.UserRegisterForm;
import com.example.task2.entity.User;
import com.example.task2.exception.UserAlreadyRegisteredException;
import com.example.task2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public void register(UserRegisterForm form) {
        if (userRepo.existsByEmail(form.getEmail())) {
            throw new UserAlreadyRegisteredException();
        }

        var user = User.builder()
                .email(form.getEmail())
                .password(encoder.encode(form.getPassword()))
                .build();

        userRepo.save(user);
    }

}
