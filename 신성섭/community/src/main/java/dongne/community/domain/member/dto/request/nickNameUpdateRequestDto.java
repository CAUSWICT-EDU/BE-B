package dongne.community.domain.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class nickNameUpdateRequestDto {

    @NotBlank(message = "ID는 필수입니다.")
    private String signId;

    @Size(max=20, message = "사용가능한 닉네임의 최대 길이는 20자 입니다.")
    private String nickName;

}
