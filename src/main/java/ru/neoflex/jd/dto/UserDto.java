package ru.neoflex.jd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.neoflex.jd.dto.enumerated.Role;

/**
 * DTO for {@link ru.neoflex.jd.entity.User}
 */
@Data
@Builder
public class UserDto {
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Role role;
}