package FAQ.faqcenter.controller.signup.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SignUpForm {

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

}
