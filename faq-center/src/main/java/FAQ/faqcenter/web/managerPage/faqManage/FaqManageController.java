package FAQ.faqcenter.web.managerPage.faqManage;

import FAQ.faqcenter.domain.faq.Faq;
import FAQ.faqcenter.repository.faqRepository.inf.FaqRepository;
import FAQ.faqcenter.web.faqs.form.FaqForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/managerPage/faqManage")
public class FaqManageController {

    private final FaqRepository faqRepository;

    @GetMapping
    public String faqManage(Model model) {

        List<Faq> faqs = faqRepository.findAll();

        model.addAttribute("faqs", faqs);
        return "managerPage/faqManage/faqManage";
    }

    @PostMapping("/removeFaq/{manageNum}")
    public String removeFaq(@PathVariable(name = "manageNum")Long manageNum, Model model
            , @ModelAttribute FaqForm faqForm) {

        if(!faqRepository.findByNum(manageNum).isEmpty()){
            faqRepository.removeFaqByNum(manageNum);
            return "redirect:/managerPage/faqManage";
        }

        return "redirect:/managerPage/faqManage";
    }



    @PostMapping("/editFaq/{manageNum}")
    public String editFaq(@PathVariable(name = "manageNum")Long manageNum, Model model
    , @ModelAttribute FaqForm faqForm) {

        Optional<Faq> findFaq = faqRepository.findByNum(manageNum);
        if(findFaq==null){
            return "redirect:/managerPage/faqManage";
        }
        Faq faq = findFaq.get();
        model.addAttribute("faq",faq);
        return "managerPage/faqManage/editFaq";
    }


    @PostMapping("/editFaq/{manageNum}/save")
    public String editFaqSave(Model model,
                              @PathVariable(name = "manageNum")Long manageNum,
                              @ModelAttribute FaqForm faqForm) {

        Faq updatedFaq = new Faq(faqForm.getTitle(), faqForm.getQuestionMember(), faqForm.getQuestion(), faqForm.getAnswer());
        faqRepository.update(manageNum, updatedFaq);

        return "redirect:/managerPage/faqManage";
    }





    @GetMapping("/addFaq")
    public String addFaqGet(@ModelAttribute("faqForm") FaqForm faqForm) {
        return "/managerPage/faqManage/addFaq";
    }

    @PostMapping("/addFaq")
    public String addFaqPost(@Valid @ModelAttribute("faqForm") FaqForm faqForm,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/managerPage/faqManage/addFaq";
        }

        //success
        faqRepository.save(new Faq(faqForm.getTitle(),faqForm.getQuestionMember(),faqForm.getQuestion(),faqForm.getAnswer()));

        return "redirect:/managerPage/faqManage";
    }


}
