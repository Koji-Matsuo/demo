package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.TContact;
import com.practice.form.ContactForm;

@Service
@Transactional
public interface ContactService {
	
	List<TContact> findContactList(String userId);
	
	MUser findMUser(String userId);
	
	List<MDictionary> findContactTypeList();
	
	List<MDictionary> findHowToContactList();
	
	void insertTContact(ContactForm contactForm);

}
