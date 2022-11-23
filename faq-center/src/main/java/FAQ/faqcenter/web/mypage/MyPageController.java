package FAQ.faqcenter.web.mypage;

import FAQ.faqcenter.domain.question.Question;
import FAQ.faqcenter.repository.questionRepository.inf.QuestionRepository;
import FAQ.faqcenter.config.session.SessionConst;
import FAQ.faqcenter.config.session.SessionForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final QuestionRepository questionRepository;

    @GetMapping("/mypage")
    public String myPage(@SessionAttribute(name = SessionConst.LOGIN_SESSION_KEY, required = false) SessionForm sessionForm, Model model) {

        List<Question> questions = questionRepository.findAll().stream()
                .filter(m -> m.getQuestionMember().equals(sessionForm.getNickname()))
                .collect(Collectors.toList());

        model.addAttribute("questions",questions);
        return "myPage/myPage";
    }
}
