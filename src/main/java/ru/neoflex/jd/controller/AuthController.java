package ru.neoflex.jd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.neoflex.jd.dto.UserDto;
import ru.neoflex.jd.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/registry")
    public Mono<UserDto> registryNewUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

}
