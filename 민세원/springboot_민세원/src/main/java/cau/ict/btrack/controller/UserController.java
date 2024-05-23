package cau.ict.btrack.controller;

import cau.ict.btrack.converter.UserConverter;
import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.dto.RequestUserRegisterDto;
import cau.ict.btrack.dto.ResponseUserRegisterDto;
import cau.ict.btrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{userId}/info/simple")
    public ResponseEntity<ResponseSimpleUserDto> getSimpleUserInfo(@PathVariable Long userId) {
        User user = userService.getSimpleUserInfo(userId);
        ResponseSimpleUserDto responseDto = UserConverter.convertToSimpleDto(user);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<ResponseUserRegisterDto> createUser(@RequestBody RequestUserRegisterDto userDto) {
        User createdUser = userService.createUser(userDto);
        ResponseUserRegisterDto responseDto = new ResponseUserRegisterDto(createdUser.getId());
        return new ResponseEntity<>(responseDto, HttpStatusCode.valueOf(200));
    }
}

