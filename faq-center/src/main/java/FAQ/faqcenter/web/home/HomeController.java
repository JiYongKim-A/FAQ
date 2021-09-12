package FAQ.faqcenter.web.home;

import FAQ.faqcenter.domain.faq.Faq;
import FAQ.faqcenter.domain.repositoryInterface.FaqRepository;
import FAQ.faqcenter.domain.repositoryInterface.MemberRepository;
import FAQ.faqcenter.domain.repositoryInterface.QuestionRepository;
import FAQ.faqcenter.web.WebConst.SessionConst;
import FAQ.faqcenter.web.session.form.SessionForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.net.URL;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepository memberRepository;
    private final FaqRepository faqRepository;
    private final QuestionRepository questionRepository;

    @GetMapping("/")
    public String home(
            @SessionAttribute(name = SessionConst.LOGIN_SESSION_KEY, required = false) SessionForm sessionForm,
            Model model) {

        List<Faq> all = faqRepository.findAll();
        model.addAttribute("faqs", all);

        if(sessionForm == null){

            return "home";
        }

        model.addAttribute("sessionForm",sessionForm);
        return "loginHome";
    }

}
