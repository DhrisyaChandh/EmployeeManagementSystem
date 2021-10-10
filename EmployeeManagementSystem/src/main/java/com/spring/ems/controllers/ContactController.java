
package com.spring.ems.controllers;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.ems.entities.Contact;
import com.spring.ems.repositories.ContactRepository;


/**
 * Controller is used for contact information crud operations
 * 
 * @author Dhrisya Chandran
 * @since 08.10.2021
 *
 */

@RestController
@RequestMapping("/contact")
public class ContactController {


	@Autowired
	private ContactRepository repository;

	/*
	 * getContactInfo is used to get details of an employee
	 * @body contact
	 * @return ResponseEntity of String
	 */

	@GetMapping("/getdetails")
	public ResponseEntity<Contact> getContactInfo(@RequestBody Contact contact) {

		int id = contact.getEmployee_ID_Number();
		Optional<Contact> _contact=repository.findById(id);

		if (_contact.isPresent()) {
			return new ResponseEntity<>(_contact.get(), HttpStatus.OK);
		}else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	

	}

	/*
	 * CreateContactInfo is used to add details of a new employee
	 * @body contact
	 * @return ResponseEntity of String
	 */

	@PostMapping("/postdetails")
	public ResponseEntity<Contact> createContactInfo(@RequestBody Contact contact) {

		try {
			Contact _contact = repository.save(contact);
			return new ResponseEntity<>(_contact, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}  
	}

	/*
	 * updateContactInfo is used to update details of an existing employee
	 * @body contact
	 * @return ResponseEntity of String
	 */

	@PutMapping("/updatedetails")
	public ResponseEntity<Contact> updateContactInfo(@RequestBody Contact contact) {

		int id = contact.getEmployee_ID_Number();
		Optional<Contact> ContactData = repository.findById(id);

		if (ContactData.isPresent()) {	
			Contact _contact = ContactData.get();
			_contact.setC_First_Name(contact.getC_First_Name());
			_contact.setC_Middle_Name(contact.getC_Middle_Name());
			_contact.setC_Last_Name(contact.getC_Last_Name());
			_contact.setC_Cellular_Phone(contact.getC_Cellular_Phone());
			_contact.setC_Home_Phone(contact.getC_Home_Phone());
			_contact.setC_City(contact.getC_City());
			_contact.setC_Address(contact.getC_Address());

			return new ResponseEntity<>(repository.save(_contact), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * deletContactInfo is used to delete details of an employee
	 * @body contact
	 * @return ResponseEntity of String
	 */

	@DeleteMapping("/contactdelete")
	public ResponseEntity<HttpStatus> deleteContactInfo(@RequestBody Contact contact) {

		int id = contact.getEmployee_ID_Number();

		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}

