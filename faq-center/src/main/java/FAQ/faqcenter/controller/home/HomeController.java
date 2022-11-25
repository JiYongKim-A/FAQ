package FAQ.faqcenter.controller.home;

import FAQ.faqcenter.domain.authority.Authority;
import FAQ.faqcenter.domain.faq.Faq;
import FAQ.faqcenter.domain.member.Member;
import FAQ.faqcenter.repository.faqRepository.inf.FaqRepository;
import FAQ.faqcenter.config.session.SessionConst;
import FAQ.faqcenter.config.session.SessionForm;
import FAQ.faqcenter.repository.memberRepository.inf.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepository memberRepository;
    private final FaqRepository faqRepository;

    @GetMapping("/")
    public String home(
            @SessionAttribute(name = SessionConst.LOGIN_SESSION_KEY, required = false) SessionForm sessionForm,
            Model model) {

        List<Faq> all = faqRepository.findAll();
        model.addAttribute("faqs", all);

        if(sessionForm == null){

            return "home";
        }
        String id = sessionForm.getLoginId();
        if(memberRepository.findByLoginId(id).get().getAuthority().equals(Authority.ADMIN) ||
                memberRepository.findByLoginId(id).get().getAuthority().equals(Authority.MANAGER)){
            model.addAttribute("manager", true);
        }else{
            model.addAttribute("manager", false);
        }
        model.addAttribute("sessionForm",sessionForm);
        return "loginHome";
    }

}
