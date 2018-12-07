package com.crud.library.controller;

import com.crud.library.domain.dto.UserDto;
import com.crud.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto).getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public UserDto getUser(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public UserDto changeUserDetails(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
