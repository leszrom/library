package com.crud.library.service;

import com.crud.library.controller.UserNotFoundException;
import com.crud.library.domain.User;
import com.crud.library.domain.dto.UserDto;
import com.crud.library.mapper.UserMapper;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private static final String USER_DOES_NOT_EXIST = "The user with the given id does not exist";
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto saveUser(final UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        user.setCreated(new Date());
        return userMapper.mapToUserDto(userRepository.save(user));
    }

    public UserDto getUserById(final Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(USER_DOES_NOT_EXIST));
        return userMapper.mapToUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoList(userRepository.findAll());
    }

    public UserDto updateUser(final Long id, final UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        if (userRepository.findById(id).isPresent()) {
            Date created = userRepository.findById(id).get().getCreated();
            user.setCreated(created);
        } else {
            user.setCreated(new Date());
        }
        return userMapper.mapToUserDto(userRepository.save(user));
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }
}
