package FAQ.faqcenter.domain.faq;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter @Setter
public class Faq {


    private long num;

    @NotNull
    private String title;

    @NotNull
    private String questionMember;

    private String question;

    private String answer;

    public Faq(@NotNull String title, @NotNull String questionMember, String question, String answer) {
        this.title = title;
        this.questionMember = questionMember;
        this.question = question;
        this.answer = answer;
    }
}
