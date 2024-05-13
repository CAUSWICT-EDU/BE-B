package cau.ict.btrack.controller;

import cau.ict.btrack.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{user_id}/info/simple")
    public ResponseEntity<ResponseSimpleDto> getSimpleUserInfo(@PathVariable Long userId) {
        ResponseSimpleDto userInfo = userService.getSimpleUserInfo(userId);
        return ResponseEntity.ok(userInfo);
    }
}