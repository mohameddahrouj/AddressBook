package lab.controller;

import lab.model.AddressBook;
import lab.model.BuddyInfo;
import lab.repository.AddressBookRepository;
import lab.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
    @Autowired
    private AddressBookController abController;

    @GetMapping("/thebook")
    public String greetingForm(Model model){
        model.addAttribute("book", abController.getAddressBook(new Long(1)));
        model.addAttribute("buddyinfo", new BuddyInfo());
        return "book";
    }

    @PostMapping("/thebook")
    public String greetingSubmit(Model model, @ModelAttribute BuddyInfo bud){
        abController.createBuddyInfo(new Long(1), bud);
        model.addAttribute("book", abController.getAddressBook(new Long(1)));
        model.addAttribute("lastbuddy", bud.getFirstName()+ " " + bud.getLastName());
        return "result";
    }

}
