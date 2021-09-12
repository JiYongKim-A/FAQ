package FAQ.faqcenter.web.mypage.myQuestion;

import FAQ.faqcenter.domain.question.Question;
import FAQ.faqcenter.domain.repositoryInterface.QuestionRepository;
import FAQ.faqcenter.web.WebConst.SessionConst;
import FAQ.faqcenter.web.mypage.myQuestion.form.MyQuestionForm;
import FAQ.faqcenter.web.session.form.SessionForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.Valid;
import java.util.Optional;
@Slf4j
@Controller
@RequiredArgsConstructor
public class MyQuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/Question/{QuestionManageNum}")
    public String question(
            @ModelAttribute("myQuestionForm")MyQuestionForm form,
            @PathVariable("QuestionManageNum")Long manageNum,
            @SessionAttribute(name = SessionConst.LOGIN_SESSION_KEY,required = false) SessionForm sessionForm,
            Model model) {
        String sessionNickname = sessionForm.getNickname();


        Optional<Question> findQuestion = questionRepository.findQuestionByNum(manageNum);
        log.info("findquestion = {}", findQuestion);
            if(findQuestion == null){
                model.addAttribute("question",form);
            }
        Question question = findQuestion.get();
            if (question.getQuestionMember().equals(sessionNickname)){

                model.addAttribute("question",question);

                return "myPage/detailQuestion/detailQuestion";
            }
        // 변경점
           return "redirect:/";
    }
}
