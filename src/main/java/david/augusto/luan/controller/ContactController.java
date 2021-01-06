package david.augusto.luan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import david.augusto.luan.controller.exceptions.EmailAlreadyRegistered;
import david.augusto.luan.controller.exceptions.UserDoesNotExist;
import david.augusto.luan.domain.Contact;
import david.augusto.luan.repositories.ContactRepository;

@RestController
@RequestMapping(value = { "/contacts" })
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@GetMapping
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
		return contactRepository.findById(id).map(record -> ResponseEntity.ok().body(id))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Contact create(@RequestBody Contact contact) throws EmailAlreadyRegistered {
		List<Contact> list = contactRepository.findAll();
		list.forEach(i -> {
			if (i.getEmail().equals(contact.getEmail())) {
				throw new EmailAlreadyRegistered(HttpStatus.BAD_REQUEST, "Email já cadastrado!");
			}
		});
		return contactRepository.save(contact);
	}

	@PutMapping(path = { "/{id}" })
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Contact contact) throws UserDoesNotExist {
		return contactRepository.findById(id).map(record -> {
			record.setName(contact.getName());
			record.setEmail(contact.getEmail());
			record.setPassword(contact.getPassword());
			return ResponseEntity.ok().body(record);
		}).orElseThrow(() -> new UserDoesNotExist(HttpStatus.BAD_REQUEST, "Usuario não encontrado!"));
	}
}