package FAQ.faqcenter.web.managerPage;

import FAQ.faqcenter.domain.authority.Authority;
import FAQ.faqcenter.domain.member.Member;
import FAQ.faqcenter.domain.repositoryInterface.MemberRepository;
import FAQ.faqcenter.web.WebConst.SessionConst;
import FAQ.faqcenter.web.session.form.SessionForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ManagerPageController {

    private final MemberRepository memberRepository;

    @GetMapping("/managerPage")
    public String managerPage(
            @SessionAttribute(name = SessionConst.LOGIN_SESSION_KEY, required = false)SessionForm sessionForm) {



        if(sessionForm == null){
            return "redirect:/";
        }
        String loginId = sessionForm.getLoginId();
        Optional<Member> loginMember = memberRepository.findByLoginId(loginId);

        if (loginMember==null){
            return "redirect:/";
        }
        Authority authority = loginMember.get().getAuthority();

        if(authority == null){
            return "redirect:/";
        }

        //success logic
        return "managerPage/mangerPage";

    }

}
