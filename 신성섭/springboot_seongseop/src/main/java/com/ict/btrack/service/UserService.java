package com.ict.btrack.service;

import com.ict.btrack.domain.User;
import com.ict.btrack.dto.ResponseSimpleUserDto;
import com.ict.btrack.exception.BaseException;
import com.ict.btrack.repository.UserRepository;
import com.ict.btrack.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseSimpleUserDto getSimpleUserInfo(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return new ResponseSimpleUserDto(user.get().getName(), user.get().getHeight(), user.get().getAge() );
        }else{
             throw new BaseException(ResponseCode.USER_NOT_FOUND);
        }

    }
}