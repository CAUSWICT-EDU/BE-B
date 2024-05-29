package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.apiPayload.ApiResponse;
import cau.ict.btrack_week6.converter.TempConverter;
import cau.ict.btrack_week6.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

//    @GetMapping("/test")
//    public ApiResponse<TempResponse.TempTestDto> testApi() {
//        return ApiResponse.onSuccess(TempConverter.toTempTestDto());
//    }
}
