package com.crud.library.service;

import com.crud.library.controller.UserNotFoundException;
import com.crud.library.domain.User;
import com.crud.library.domain.dto.UserDtoRequest;
import com.crud.library.domain.dto.UserDto;
import com.crud.library.mapper.UserMapper;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Long saveUser(final UserDtoRequest userDtoRequest) {
        User user = userMapper.mapToUser(userDtoRequest);
        return userRepository.save(user).getId();
    }

    public UserDto getUserById(final Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.mapToUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoList(userRepository.findAll());
    }

    public UserDto updateUser(final Long id, final UserDtoRequest userDtoRequest) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setId(id);
        user.setFirstname(userDtoRequest.getFirstname());
        user.setLastname(userDtoRequest.getLastname());
        return userMapper.mapToUserDto(userRepository.save(user));
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }
}
