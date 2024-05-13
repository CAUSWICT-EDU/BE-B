package cau.ict.btrack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSimpleUserDto {
    private String name; // 닉네임
    private int height; // 키
    private int age; // 나이
}