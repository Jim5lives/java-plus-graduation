package ru.yandex.practicum;

import feign.FeignException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.yandex.practicum.model.UserDto;
import ru.yandex.practicum.request.NewUserRequest;

import java.util.List;

@Validated
@FeignClient(name = "user-service", path = "admin/users")
public interface UserServiceFeignClient {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto createUser(@Valid @RequestBody NewUserRequest request) throws FeignException;

    @GetMapping
    List<UserDto> findUsers(@RequestParam(required = false) List<Long> ids,
                            @RequestParam(value = "from", defaultValue = "0") int from,
                            @RequestParam(value = "size", defaultValue = "10") int size) throws FeignException;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable @Positive long id) throws FeignException;
}
