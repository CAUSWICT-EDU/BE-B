package cau.ict.btrack.service;

import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    /***
     * 적어도 닉네임, 키, 나이 필드 값 넘겨주기
     * @param userId
     * @return
     */
    public ResponseSimpleUserDto getSimpleUserInfo(Long userId) {

        return null;
    }
}
