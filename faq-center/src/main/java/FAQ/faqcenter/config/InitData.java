package FAQ.faqcenter.config;

import FAQ.faqcenter.domain.authority.Authority;
import FAQ.faqcenter.domain.faq.Faq;
import FAQ.faqcenter.domain.member.Member;
import FAQ.faqcenter.domain.question.Question;
import FAQ.faqcenter.repository.faqRepository.inf.FaqRepository;
import FAQ.faqcenter.repository.memberRepository.inf.MemberRepository;
import FAQ.faqcenter.repository.questionRepository.inf.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {
    private final MemberRepository memberRepository;
    private final FaqRepository faqRepository;
    private final QuestionRepository questionRepository;

    @PostConstruct
    public void init(){
        //초기 사용자 등록
        Member firstMem = new Member("김지용", "rlawldyd", "김지용", "김지용");
        firstMem.setAuthority(Authority.ADMIN);

        Member secondMem = new Member("김용기", "rladydrl", "김용기", "김용기");
        secondMem.setAuthority(Authority.MANAGER);

        Member thirdMem = new Member("신범철", "tlsqjacjf", "신범철", "신범철");
        thirdMem.setAuthority(Authority.MANAGER);


        memberRepository.save(firstMem);
        memberRepository.save(secondMem);
        memberRepository.save(thirdMem);


        //기본 faq 등록
        faqRepository.save(new Faq("로그인이 되지 않아요","다수 사용자"
                ,"로그인을 하려고 회원가입을 했지만 회원 가입이 되어있지 않습니다."
                ,"회원 가입을 다시 한번 시도해 주세요"));

        faqRepository.save(new Faq("정답 수정을 어떻게 해야하죠?","다수 사용자"
                ,"정답을 작성했지만 다시 수정해야하는데 수정 버튼이 눌려지지가 않아요."
                ,"로그아웃 이후 다시 로그인 하시고 다시 한번 수정을 해보시기 바랍니다."));

        //기본 question 등록
        Question question = new Question("웹 페이지 접근 권한", "사용자"
                , "웹 페이지 접근 권한을 얻으려면 어떻게 해야하나요?");
        question.setAnswerStatus("N");
        questionRepository.save(question);
    }
}
