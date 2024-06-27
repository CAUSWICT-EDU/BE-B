package dongne.community.domain.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequestDto {

    @NotBlank(message = "글을 작성하려면 ID가 필요합니다.")
    private String signId;

    @NotBlank(message = "게시물의 제목을 입력하세요.")
    private String title;

    @NotBlank(message = "게시물의 내용을 입력하세요.")
    private String content;

}
