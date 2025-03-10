package ru.practicum.ewm.event.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.dto.EventState;


@Component
public class EventStateConverter implements Converter<String, EventState> {
    @Override
    public EventState convert(String source) {
        return EventState.valueOf(source.toUpperCase());
    }
}


