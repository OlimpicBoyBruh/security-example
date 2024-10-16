package ru.neoflex.jd.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.jd.dto.UserDto;
import ru.neoflex.jd.entity.User;
import ru.neoflex.jd.mapping.UserConverter;
import ru.neoflex.jd.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements ReactiveUserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        log.info("findByUsername {}", username);
        return userRepository.findByUsername(username).cast(UserDetails.class);
    }

    public Mono<UserDto> createUser(UserDto userDto) {
        User user = UserConverter.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("createUser {}", userDto);
        return userRepository.save(user).map(UserConverter::toDto);
    }

    public Mono<UserDto> getUser(Long id) {
        return userRepository.findById(id).map(UserConverter::toDto);
    }

    public Flux<UserDto> getAllUsers() {
        return userRepository.findAll().map(UserConverter::toDto);
    }
}
