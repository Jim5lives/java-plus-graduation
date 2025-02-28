package ru.yandex.practicum.service;

import ru.yandex.practicum.request.FindUsersParams;
import ru.yandex.practicum.request.NewUserRequest;
import ru.yandex.practicum.model.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(NewUserRequest request);

    List<UserDto> findUsers(FindUsersParams params);

    void deleteUser(long id);
}
