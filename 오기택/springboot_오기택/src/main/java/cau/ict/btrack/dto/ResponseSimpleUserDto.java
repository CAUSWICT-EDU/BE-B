package cau.ict.btrack.dto;

import cau.ict.btrack.domain.User;

public class ResponseSimpleUserDto {
    private String name; // 닉네임
    private int height; // 키
    private int age; // 나이

    public ResponseSimpleUserDto(User user){
        this.name = user.getName();
        this.height = user.getHeight();
        this.age = user.getAge();
    }
}
