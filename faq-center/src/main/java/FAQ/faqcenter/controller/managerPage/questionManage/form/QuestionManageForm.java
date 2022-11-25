package FAQ.faqcenter.controller.managerPage.questionManage.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class QuestionManageForm {

    @NotEmpty
    private String answer;


}
