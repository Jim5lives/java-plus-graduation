package ru.yandex.practicum;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yandex.practicum.dto.RequestCountDto;

import java.util.List;

@FeignClient(name = "request-service", path = "/users")
public interface RequestServiceFeignClient {

    @GetMapping("/requests")
    List<RequestCountDto> findConfirmedRequest(@RequestParam List<Long> ids);
}
