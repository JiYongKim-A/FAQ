package FAQ.faqcenter.config.interceptor;

import FAQ.faqcenter.domain.member.Member;
import FAQ.faqcenter.repository.memberRepository.inf.MemberRepository;
import FAQ.faqcenter.config.session.SessionConst;
import FAQ.faqcenter.config.session.SessionForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
public class ManagerCheckInterceptor implements HandlerInterceptor {

    private final MemberRepository memberRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.LOGIN_SESSION_KEY);
        if(session == null||sessionForm==null){
            response.sendRedirect("/");
            return false;
        }

        Optional<Member> findMember = memberRepository.findByLoginId(sessionForm.getLoginId());
        if(findMember.isEmpty()){
            response.sendRedirect("/");
            return false;
        }

        Member member = findMember.get();

        if(member.getAuthority() == null){
            response.sendRedirect("/");
            return false;
        }

        return true;
    }
}
