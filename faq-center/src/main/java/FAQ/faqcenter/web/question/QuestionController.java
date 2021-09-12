package FAQ.faqcenter.web.question;

import FAQ.faqcenter.domain.question.Question;
import FAQ.faqcenter.domain.repositoryInterface.QuestionRepository;
import FAQ.faqcenter.web.WebConst.SessionConst;
import FAQ.faqcenter.web.question.form.QuestionForm;
import FAQ.faqcenter.web.session.form.SessionForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/questionForm")
    public String question(
            @SessionAttribute(name = SessionConst.LOGIN_SESSION_KEY, required = false)SessionForm sessionForm,
            @ModelAttribute("questionForm")QuestionForm questionForm,
            Model model) {

        String nickName = sessionForm.getNickname();
        log.info("nickname={}",nickName);
        model.addAttribute("SessionNickName",nickName);
        return "question/questionForm";
    }

    @PostMapping("/questionForm")
    public String question(@Valid @ModelAttribute("questionForm")QuestionForm questionForm,
                           BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "question/questionForm";
        }

        //success logic

        Question question = new Question(questionForm.getTitle(),questionForm.getQuestionMember(),questionForm.getQuestion());
        question.setAnswerStatus("N");
        questionRepository.save(question);
        return "redirect:/";
    }

}
