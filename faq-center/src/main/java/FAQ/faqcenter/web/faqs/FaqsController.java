package FAQ.faqcenter.web.faqs;

import FAQ.faqcenter.domain.faq.Faq;
import FAQ.faqcenter.repository.faqRepository.inf.FaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
@Slf4j
@Controller
@RequestMapping("/FAQ")
@RequiredArgsConstructor
public class FaqsController {

public final FaqRepository faqRepository;

    @GetMapping("/{faqNum}")
    public String faq(Model model, @PathVariable Long faqNum){
        log.info("faqNum={}",faqNum);
        Optional<Faq> FAQ = faqRepository.findByNum(faqNum);
        if(FAQ.isEmpty()){
          return "redirect:/";
        }
        Faq faq = FAQ.get();

        model.addAttribute("faq",faq);
        return "faq/faq";


    }
}
