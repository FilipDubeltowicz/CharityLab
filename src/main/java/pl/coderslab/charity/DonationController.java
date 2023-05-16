package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DonationController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;

    public DonationController(InstitutionRepository institutionRepository, DonationRepository donationRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/form")
    public String donationForm(Model model){
        Donation donation = new Donation();
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("donation", donation);
        model.addAttribute("institutions", institutionRepository.findAll());
        return "form";
    }

    @PostMapping("/form")
    public String processForm(@ModelAttribute("donation") Donation donation){
        donationRepository.save(donation);
        return "form-confirmation";
    }
}
