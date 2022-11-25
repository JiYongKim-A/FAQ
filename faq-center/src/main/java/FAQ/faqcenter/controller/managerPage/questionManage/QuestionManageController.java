package FAQ.faqcenter.controller.managerPage.questionManage;

import FAQ.faqcenter.domain.question.Question;
import FAQ.faqcenter.repository.questionRepository.inf.QuestionRepository;
import FAQ.faqcenter.controller.managerPage.questionManage.form.QuestionManageForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/managerPage/questionManage")
public class QuestionManageController {

    private final QuestionRepository questionRepository;

    @GetMapping
    public String questionManage(Model model) {

        List<Question> all = questionRepository.findAll();
        model.addAttribute("questions",all);

        return "managerPage/questionManage/questionManage";
    }

    @GetMapping("/answer/{manageNum}")
    public String questionAnswer(@PathVariable(name = "manageNum")Long manageNum,
        @ModelAttribute("questionManageForm") QuestionManageForm questionManageForm,
                                 Model model){


        Optional<Question> questionByNum = questionRepository.findQuestionByNum(manageNum);
        if(questionByNum.isEmpty()){
            return "redirect:/managerPage/questionManage";
        }

        Question question = questionByNum.get();
        model.addAttribute("question", question);

        return "managerPage/questionManage/questionAnswer";
    }

    @PostMapping("/answer/{manageNum}")
    public String questionAnswer(
            @PathVariable(name = "manageNum")Long manageNum,
            @Valid @ModelAttribute("questionManageForm") QuestionManageForm questionManageForm,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "managerPage/questionManage/questionAnswer";
        }

        Optional<Question> questionByNum = questionRepository.findQuestionByNum(manageNum);
        if(questionByNum.isEmpty()){
            return "redirect:/managerPage/questionManage";
        }
        Question question = questionByNum.get();
        question.setAnswer(questionManageForm.getAnswer());
        question.setAnswerStatus("Y");

        questionRepository.update(manageNum,question);

        return "redirect:/managerPage/questionManage";

    }




}
