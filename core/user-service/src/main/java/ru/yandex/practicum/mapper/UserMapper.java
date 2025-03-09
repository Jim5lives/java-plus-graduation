package ru.yandex.practicum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.yandex.practicum.dto.UserShortDto;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.dto.NewUserRequest;
import ru.yandex.practicum.dto.UserDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User mapToUser(NewUserRequest request);

    UserDto mapToUserDto(User user);

    List<UserDto> mapToUsersDto(List<User> users);

    List<UserShortDto> mapToUserShortDto(List<User> users);
}
