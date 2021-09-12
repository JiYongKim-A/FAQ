package FAQ.faqcenter.web.question.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class QuestionForm {


    @NotEmpty
    private String title;

    private String questionMember;

    @NotEmpty
    private String question;


}
