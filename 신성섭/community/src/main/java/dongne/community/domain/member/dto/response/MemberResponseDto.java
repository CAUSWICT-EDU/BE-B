package dongne.community.domain.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {

    private String signID;

    private String NickName;

}
