package ru.yandex.practicum.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.RequestServiceFeignClient;
import ru.yandex.practicum.dto.ParamEventDto;
import ru.yandex.practicum.dto.ParticipationRequestDto;
import ru.yandex.practicum.dto.EventRequestStatusUpdateRequest;
import ru.yandex.practicum.dto.EventRequestStatusUpdateResult;
import ru.yandex.practicum.dto.RequestCountDto;
import ru.yandex.practicum.service.RequestService;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class PrivateRequestController implements RequestServiceFeignClient {
    private final RequestService requestService;

    @GetMapping("/{userId}/events/{eventId}/requests")
    public List<ParticipationRequestDto> findEventRequest(@Positive @PathVariable long userId,
                                                          @Positive @PathVariable long eventId) {
        ParamEventDto paramEventDto = new ParamEventDto(userId, eventId);
        log.info("Request to find eventRequests {}", paramEventDto);
        return requestService.findRequest(paramEventDto);
    }

    @PatchMapping("/{userId}/events/{eventId}/requests")
    public EventRequestStatusUpdateResult updateEventRequest(@Positive @PathVariable long userId,
                                                             @Positive @PathVariable long eventId,
                                                             @RequestBody EventRequestStatusUpdateRequest updateEvent) {
        ParamEventDto paramEventDto = new ParamEventDto(userId, eventId);
        log.info("Request to update eventRequests {}", paramEventDto);
        return requestService.updateRequest(paramEventDto, updateEvent);
    }

    @Override
    public List<RequestCountDto> findConfirmedRequest(List<Long> ids) {
        log.info("Received request to find confirmed requests with ids: {}", ids);
        return requestService.findConfirmedRequest(ids);
    }
}
