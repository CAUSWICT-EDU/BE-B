package board.board.controller;


import board.board.apiPayload.ApiResponse;
import board.board.dto.member.MemberRequest;
import board.board.dto.member.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    @PostMapping("/join")
    public ApiResponse<MemberResponse.MemberDto> join(@RequestBody MemberRequest.JoinDto joinDto){
        MemberResponse.MemberDto memberDto =
    }
}
