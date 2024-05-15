package cau.ict.btrack.controller;

import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.exception.BaseException;
import cau.ict.btrack.service.UserService;
import cau.ict.btrack.util.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{userId}/info/simple")
    public ResponseEntity<ResponseSimpleUserDto> getSimpleUserInfo(@PathVariable Long userId) {
        ResponseSimpleUserDto userInfo = userService.getSimpleUserInfo(userId);

        if (userInfo == null) {
            throw new BaseException(ResponseCode.USER_NOT_FOUND);
        }
        return ResponseEntity.ok(userInfo);
    }

    //BaseException 핸들러
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<String> handleBaseException(BaseException e) {
        return ResponseEntity.status(e.getResponseCode().getHttpStatus())
                .body(e.getResponseCode().getMessage());
    }
}