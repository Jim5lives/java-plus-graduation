package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.CommentDto;
import ru.yandex.practicum.dto.NewCommentRequest;
import ru.yandex.practicum.dto.params.CommentParams;
import ru.yandex.practicum.dto.ParamEventDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(ParamEventDto params, NewCommentRequest request);

    void deleteComment(CommentParams params);

    List<CommentDto> findEventComment(ParamEventDto paramEventDto);

    List<CommentDto> findUserComments(long userId);

    CommentDto updateComment(CommentParams params, NewCommentRequest request);
}
