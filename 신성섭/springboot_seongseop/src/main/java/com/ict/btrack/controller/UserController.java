package com.ict.btrack.controller;

import com.ict.btrack.dto.ResponseSimpleUserDto;
import com.ict.btrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{userId}/info/simple")
    public ResponseEntity<ResponseSimpleUserDto> getSimpleUserInfo(@PathVariable Long userId) {
        ResponseSimpleUserDto userInfo = userService.getSimpleUserInfo(userId);
        return ResponseEntity.ok(userInfo);
    }
}
