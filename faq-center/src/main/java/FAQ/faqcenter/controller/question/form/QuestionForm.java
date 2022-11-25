package FAQ.faqcenter.controller.question.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class QuestionForm {


    @NotEmpty
    private String title;

    private String questionMember;

    @NotEmpty
    private String question;


}
