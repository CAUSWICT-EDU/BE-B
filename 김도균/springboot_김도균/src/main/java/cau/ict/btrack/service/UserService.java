package cau.ict.btrack.service;

import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /***
     * 적어도 닉네임, 키, 나이 필드 값 넘겨주기
     * @param userId
     * @return
     */
    public ResponseSimpleUserDto getSimpleUserInfo(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return null;
        }
        
        //DTO 생성
        ResponseSimpleUserDto responseDTO = ResponseSimpleUserDto.builder()
                .name(optionalUser.get().getName())
                .height(optionalUser.get().getHeight())
                .age(optionalUser.get().getAge())
                .build();
        return responseDTO;
    }
}