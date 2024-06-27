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
public class PostDeleteRequestDto {

    @NotBlank(message = "글을 삭제하려면 ID가 필요합니다.")
    private String signId;

}
