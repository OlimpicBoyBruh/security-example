package ru.neoflex.jd.mapping;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.neoflex.jd.dto.UserDto;
import ru.neoflex.jd.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {
    public static User toEntity(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .role(userDto.getRole())
                .password(userDto.getPassword())
                .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .password(user.getPassword())
                .build();
    }
}
