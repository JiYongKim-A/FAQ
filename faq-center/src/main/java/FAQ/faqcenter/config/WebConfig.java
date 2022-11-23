package FAQ.faqcenter.config;

import FAQ.faqcenter.repository.memberRepository.inf.MemberRepository;
import FAQ.faqcenter.web.interceptor.LoginCheckInterceptor;
import FAQ.faqcenter.web.interceptor.ManagerCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final MemberRepository memberRepository;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/",
                        "/signup",
                        "/login",
                        "/logout",
                        "/css/**",
                        "/img/**",
                        "/*.ico",
                        "/error",
                        "/FAQ/**");

        registry.addInterceptor(new ManagerCheckInterceptor(memberRepository))
                .order(2)
                .addPathPatterns("/managerPage/**");

    }

}
