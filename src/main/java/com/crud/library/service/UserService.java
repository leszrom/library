package com.crud.library.service;

import com.crud.library.domain.User;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(final User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(final Long id) {
        return userRepository.findById(id);
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }
}
