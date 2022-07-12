package in.raj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.raj.entity.Contact;
import in.raj.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSwitch('Y');

		Contact save = contactRepo.save(contact);
		if (save != null && save.getContactId() != null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Contact> getAllContacts() {

		List<Contact> findAll = contactRepo.findAll();

		return findAll.stream().filter(contact -> contact.getActiveSwitch() == 'Y').collect(Collectors.toList());

	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);

		if (findById.isPresent()) {
			return findById.get();
		}

		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		Optional<Contact> optional = contactRepo.findById(contactId);
		if (optional.isPresent()) {
			Contact contact = optional.get();
			contact.setActiveSwitch('N');
			contactRepo.save(contact);
			return true;

		}

		return false;
	}

}
