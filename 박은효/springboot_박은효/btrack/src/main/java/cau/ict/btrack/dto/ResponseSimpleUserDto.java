package cau.ict.btrack.dto;

import lombok.Getter;

@Getter
public class ResponseSimpleUserDto {

    private String name;

    private int height;

    private int age;

    public ResponseSimpleUserDto(String name, int height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
}
