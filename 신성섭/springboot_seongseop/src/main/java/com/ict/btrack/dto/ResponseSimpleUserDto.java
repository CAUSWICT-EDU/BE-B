package com.ict.btrack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseSimpleUserDto {
    private final String name; // 닉네임
    private final int height; // 키
    private final int age; // 나이

}
