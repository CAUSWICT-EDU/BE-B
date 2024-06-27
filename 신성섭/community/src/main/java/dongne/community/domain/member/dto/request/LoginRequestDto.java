package dongne.community.domain.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "ID를 입력해주세요")
    private String signId;

    @NotBlank(message = "PW를 입력해주세요")
    private String password;

}
