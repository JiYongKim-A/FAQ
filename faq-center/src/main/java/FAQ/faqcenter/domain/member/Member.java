package FAQ.faqcenter.domain.member;

import FAQ.faqcenter.domain.authority.Authority;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter @Setter
public class Member {

    private Long id;

    @NotEmpty
    @NotNull
    @NotBlank
    private String loginId; // 로그인 아이디

    @NotEmpty
    @NotNull
    @NotBlank

    private String password;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String nickname;

    private Authority authority ;

    public Member(@NotEmpty @NotNull @NotBlank String loginId, @NotEmpty @NotNull @NotBlank String password, @NotNull @NotEmpty String name, @NotNull @NotEmpty String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }
}
