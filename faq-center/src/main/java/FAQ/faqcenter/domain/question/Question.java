package FAQ.faqcenter.domain.question;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter @Setter
public class Question {



    private long ManageNum;

    @NotNull
    private String title;

    @NotNull
    private String questionMember;

    private String question;

    private String answer;

    private String answerStatus;

    public Question(@NotNull String title, @NotNull String questionMember, String question) {
        this.title = title;
        this.questionMember = questionMember;
        this.question = question;
    }

}
