package econovation.rere.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String userId;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nickname;

}
