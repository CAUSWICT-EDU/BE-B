package dongne.community.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimplePostResponseDto {

    private Long postId;

    private String title;

}
