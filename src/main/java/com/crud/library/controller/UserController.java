package com.crud.library.controller;

import com.crud.library.domain.dto.UserDto;
import com.crud.library.mapper.UserMapper;
import com.crud.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private static final String USER_DOES_NOT_EXIST = "The user with the given id does not exist";
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userMapper.mapToUser(userDto)).getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public UserDto getUser(@PathVariable Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_DOES_NOT_EXIST)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public UserDto changeUserDetails(@RequestBody UserDto userDto, @PathVariable Long id) {
        return userMapper.mapToUserDto(userService.updateUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
