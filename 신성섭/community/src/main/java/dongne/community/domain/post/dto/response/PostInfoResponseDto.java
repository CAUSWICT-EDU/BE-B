package dongne.community.domain.post.dto.response;

import dongne.community.domain.member.dto.response.MemberResponseDto;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class PostInfoResponseDto {

    private Long postId;

    private String title;

    private String content;

    private LocalDateTime lastUpdateTime;

    private MemberResponseDto member;

}
