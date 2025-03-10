package ru.yandex.practicum;

import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yandex.practicum.dto.EventWithInitiatorDto;

@FeignClient(name = "event-service", path = "/events")
public interface EventServiceFeignClient {

    @GetMapping("/short")
    EventWithInitiatorDto findEventWithInitiator(@RequestParam long eventId) throws FeignException;
}
