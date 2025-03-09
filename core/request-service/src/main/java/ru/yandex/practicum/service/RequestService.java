package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.ParamEventDto;
import ru.yandex.practicum.dto.EventRequestStatusUpdateResult;
import ru.yandex.practicum.dto.ParticipationRequestDto;
import ru.yandex.practicum.dto.EventRequestStatusUpdateRequest;
import ru.yandex.practicum.dto.RequestCountDto;

import java.util.List;

public interface RequestService {
    List<ParticipationRequestDto> findRequest(long userId);

    ParticipationRequestDto createRequest(long userId, long eventId);

    ParticipationRequestDto cancelRequest(long userId, long requestId);

    List<ParticipationRequestDto> findRequest(ParamEventDto paramEventDto);

    EventRequestStatusUpdateResult updateRequest(ParamEventDto paramEventDto,
                                                 EventRequestStatusUpdateRequest updateRequest);

    List<RequestCountDto> findConfirmedRequest(List<Long> ids);
}
