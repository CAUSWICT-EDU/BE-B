package cau.ict.btrack.service;

import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.dto.UserRegisterDto;
import cau.ict.btrack.exception.BaseException;
import cau.ict.btrack.repository.UserRepository;
import cau.ict.btrack.util.ResponseCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseSimpleUserDto getSimpleUserInfo(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new ResponseSimpleUserDto(user.getName(), user.getHeight(), user.getAge());
        } else {
            throw new BaseException(ResponseCode.USER_NOT_FOUND);
        }
    }

    public User createUser(UserRegisterDto user) {
        return userRepository.save(user.toEntity());
    }
}