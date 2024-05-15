package cau.ict.btrack.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseSimpleUserDto {
    private String name;
    private int height;
    private int age;

    @Builder
    public ResponseSimpleUserDto(String name, int height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

}
