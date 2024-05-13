package cau.ict.btrack.controller;

import cau.ict.btrack.domain.User;
import cau.ict.btrack.dto.ResponseSimpleUserDto;
import cau.ict.btrack.dto.UserRegisterDto;
import cau.ict.btrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{userId}/info/simple")
    public ResponseEntity<ResponseSimpleUserDto> getSimpleUserInfo(@PathVariable Long userId) {
        ResponseSimpleUserDto userInfo = userService.getSimpleUserInfo(userId);
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("")
    public User createUser(@RequestBody UserRegisterDto user) {
        return userService.createUser(user);
    }
}