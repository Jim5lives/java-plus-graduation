package ru.yandex.practicum.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "requests")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request {

    public Request(Long eventId, Long userId) {
        this.eventId = eventId;
        this.userId = userId;
        status = RequestStatus.PENDING;
        created = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "event_id")
    long eventId;

    @Column(name = "user_id")
    Long userId;

    @Enumerated(value = EnumType.ORDINAL)
    RequestStatus status;

    LocalDateTime created;
}
