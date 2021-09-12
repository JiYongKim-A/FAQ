package FAQ.faqcenter.web.faqs.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
