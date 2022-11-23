package FAQ.faqcenter.web.signup;

import FAQ.faqcenter.domain.member.Member;
import FAQ.faqcenter.repository.memberRepository.inf.MemberRepository;
import FAQ.faqcenter.web.signup.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUp(@ModelAttribute("signUpForm") SignUpForm signUpForm){
        return "signUp/signUp";
    }

    @PostMapping("/signup")
    public String signUpAdd(@Valid @ModelAttribute("signUpForm")SignUpForm signUpForm,
                            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signUp/signUp";
        }

        //success logic
        memberRepository.save(new Member(signUpForm.getLoginId(),
                signUpForm.getPassword(),
                signUpForm.getName(),
                signUpForm.getNickname()));

        return "redirect:/login";

    }



}
