package ru.yandex.practicum.controller;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.UserServiceFeignClient;
import ru.yandex.practicum.request.FindUsersParams;
import ru.yandex.practicum.request.NewUserRequest;
import ru.yandex.practicum.model.UserDto;
import ru.yandex.practicum.service.UserService;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "admin/users")
public class UserController implements UserServiceFeignClient {
    private final UserService userService;

    @Override
    public UserDto createUser(NewUserRequest request) throws FeignException {
        log.info("Received request to create new user: {}", request.getName());
        return userService.createUser(request);
    }

    @Override
    public List<UserDto> findUsers(List<Long> ids, int from, int size) throws FeignException {
        FindUsersParams params = new FindUsersParams(ids, from, size);
        log.info("Received request to find users with params: {}", params);
        return userService.findUsers(params);
    }

    @Override
    public void deleteUser(long id) throws FeignException {
        log.info("Received request to delete user with id: {}", id);
        userService.deleteUser(id);
    }
}
