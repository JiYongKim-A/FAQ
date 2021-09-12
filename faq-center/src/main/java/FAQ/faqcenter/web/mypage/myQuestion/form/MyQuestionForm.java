package FAQ.faqcenter.web.mypage.myQuestion.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MyQuestionForm {

    @NotEmpty
    private String title;

    private String questionMember;

    @NotEmpty
    private String question;

    private String answer;

}
