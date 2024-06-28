package cau.ict.btrack_week6.converter;

import cau.ict.btrack_week6.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDto toTempTestDto() {
        return TempResponse.TempTestDto.builder()
                .testString("This is test!")
                .build();
    }

    public static TempResponse.TempExceptionDto toTempExceptionDto(Integer flag) {
        return TempResponse.TempExceptionDto.builder()
                .flag(flag)
                .build();
    }
}
