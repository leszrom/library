package com.crud.library.mapper;

import com.crud.library.domain.User;
import com.crud.library.domain.dto.UserDto;
import com.crud.library.domain.dto.UserDtoRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(UserDtoRequest userDtoRequest) {
        return new User(
                userDtoRequest.getFirstname(),
                userDtoRequest.getLastname()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getCreated()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
