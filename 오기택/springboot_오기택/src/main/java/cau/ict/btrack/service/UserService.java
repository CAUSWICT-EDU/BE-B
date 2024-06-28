package cau.ict.btrack.service;

import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseSimpleUserDto getSimpleUserInfo(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(ResponseSimpleUserDto::new).orElse(null);
    }
}