package cau.ict.btrack.service;

import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.dto.RequestUserRegisterDto;
import cau.ict.btrack.exception.BaseException;
import cau.ict.btrack.repository.UserRepository;
import cau.ict.btrack.util.ResponseCode;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseSimpleUserDto getSimpleUserInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new BaseException(ResponseCode.USER_NOT_FOUND));

        return new ResponseSimpleUserDto(user.getName(), user.getHeight(), user.getAge());
    }

    public User createUser(RequestUserRegisterDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        user.setGender(userDto.getGender());
        user.setAge(userDto.getAge());

        return userRepository.save(user);
    }


}