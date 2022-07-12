package in.raj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.raj.entity.Contact;
import in.raj.service.ContactService;

@Controller
public class ContactsInfoController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contact")
	public String loadContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return ("Contact_info");
	}

	@PostMapping("/saveContact")
	public String saveContact(Contact contact, Model model) {
		boolean isSaved = contactService.saveContact(contact);
		if (isSaved) {
			model.addAttribute("Success", isSaved);
		} else {
			model.addAttribute("Failed to save", isSaved);
		}
		return "contact_info";
	}

	public String viewAllContacts(Model model) {
		List<Contact> Allcontacts = contactService.getAllContacts();
		model.addAttribute("Contact_info", Allcontacts);
		return "contact_info";

	}

}
