package com.crud.library.service;

import com.crud.library.domain.User;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(final User user) {
        user.setCreated(new Date());
        return userRepository.save(user);
    }

    public Optional<User> getUserById(final Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }
}
