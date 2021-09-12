package FAQ.faqcenter.web.login;

import FAQ.faqcenter.domain.login.LoginService;
import FAQ.faqcenter.domain.member.Member;
import FAQ.faqcenter.web.WebConst.SessionConst;
import FAQ.faqcenter.web.login.form.LoginForm;
import FAQ.faqcenter.web.session.form.SessionForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form,
                        BindingResult bindingResult,
                        HttpServletRequest request,
                        @RequestParam(defaultValue = "/") String redirectURL) {

        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null) {
            log.info("login fail info [{}][{}]",form.getLoginId(),form.getPassword());

            bindingResult.reject("loginFail","아이디 안맞음");
            log.info("bindingResult {}",bindingResult);
            return "login/loginForm";
        }

        //login success logic

        HttpSession session = request.getSession();
        SessionForm sessionForm = new SessionForm(loginMember.getLoginId(), loginMember.getNickname());
        session.setAttribute(SessionConst.LOGIN_SESSION_KEY, sessionForm);
        log.info("redirectURL = {}",redirectURL);
        return "redirect:"+redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }


}
