package FAQ.faqcenter.controller.faqs.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FaqForm {
    private long num;

    @NotEmpty
    private String title;

    @NotEmpty
    private String questionMember;

    @NotEmpty
    private String question;

    @NotEmpty
    private String answer;

}
