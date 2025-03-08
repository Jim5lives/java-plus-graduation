package ru.yandex.practicum.controller;

import feign.FeignException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
