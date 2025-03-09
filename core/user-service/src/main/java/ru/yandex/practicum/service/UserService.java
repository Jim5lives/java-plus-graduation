package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.UserShortDto;
import ru.yandex.practicum.dto.FindUsersParams;
import ru.yandex.practicum.dto.NewUserRequest;
import ru.yandex.practicum.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(NewUserRequest request);

    List<UserDto> findUsers(FindUsersParams params);

    void deleteUser(long id);

    List<UserShortDto> findShortUsers(List<Long> ids);
}
