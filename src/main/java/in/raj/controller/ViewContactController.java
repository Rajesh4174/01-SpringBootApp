package in.raj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.raj.entity.Contact;
import in.raj.service.ContactService;

public class ViewContactController {

	@Autowired
	private ContactService service;

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
      Contact contact = service.getContactById(contactId);
       model.addAttribute("contact", contact);
		return "contactInfo";
	}
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid")Integer contactId,Model model) {
		
		service.deleteContactById(contactId);
		return "View Contacts";
	}

}
