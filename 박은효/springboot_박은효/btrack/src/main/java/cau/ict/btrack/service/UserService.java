package cau.ict.btrack.service;

import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.exception.BaseException;
import cau.ict.btrack.repository.UserRepository;
import cau.ict.btrack.util.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public static User findUserByIdOrThrow(UserRepository userRepository, Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BaseException(ResponseCode.USER_NOT_FOUND));
    }

    public ResponseSimpleUserDto getSimpleUserInfo(Long userId) {
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isPresent()) {
//            ResponseSimpleUserDto dto = new ResponseSimpleUserDto(user.get().getName(), user.get().getHeight(), user.get().getAge());
//            return dto;
//        } else {
//            throw new BaseException(ResponseCode.USER_NOT_FOUND);
//        }
        Optional<User> user = Optional.ofNullable(findUserByIdOrThrow(userRepository, userId));
        ResponseSimpleUserDto dto = new ResponseSimpleUserDto(user.get().getName(), user.get().getHeight(), user.get().getAge());
        return dto;

    }
}
