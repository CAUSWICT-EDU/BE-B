package cau.ict.btrack.converter;

import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import lombok.RequiredArgsConstructor;


// repository에서 받아온 데이터를 DTO로 바꾼다.
@RequiredArgsConstructor
public class UserConverter {
    public static ResponseSimpleUserDto convertToSimpleDto(User user) {
        return new ResponseSimpleUserDto(user.getName(), user.getHeight(), user.getAge());
    }

}
