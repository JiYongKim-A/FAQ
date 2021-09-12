package FAQ.faqcenter.web.mypage;

import FAQ.faqcenter.domain.question.Question;
import FAQ.faqcenter.domain.repositoryInterface.QuestionRepository;
import FAQ.faqcenter.web.WebConst.SessionConst;
import FAQ.faqcenter.web.session.form.SessionForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
