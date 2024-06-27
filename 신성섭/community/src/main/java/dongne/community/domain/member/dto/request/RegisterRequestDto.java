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
public class RegisterRequestDto {

    @NotBlank(message = "id를 입력해주세요.")
    @Size(max=30, message = "사용가능한 ID의 최대 길이는 30자 입니다.")
    private String signId;

    @NotBlank(message = "PW를 입력해주세요.")
    @Size(max=30, message = "사용가능한 비밀번호의 최대 길이는 30자 입니다.")
    private String password;

    @NotBlank(message = "사용하실 닉네임을 입력해주세요.")
    @Size(max=20, message = "사용가능한 닉네임의 최대 길이는 20자 입니다.")
    private String nickName;

}
