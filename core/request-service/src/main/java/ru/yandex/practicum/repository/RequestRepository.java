package ru.yandex.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.yandex.practicum.dto.RequestCountDto;
import ru.yandex.practicum.model.Request;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByEventId(Long eventId);

    List<Request> findAllByUserId(Long userId);

    @Query("SELECT new ru.yandex.practicum.dto.RequestCountDto(r.eventId, count(r.id)) " +
            "FROM Request r WHERE r.eventId IN :ids " +
            "AND r.status = ru.yandex.practicum.model.RequestStatus.CONFIRMED " +
            "GROUP BY r.eventId")
    List<RequestCountDto> findConfirmedRequest(@Param("ids") List<Long> ids);
}
