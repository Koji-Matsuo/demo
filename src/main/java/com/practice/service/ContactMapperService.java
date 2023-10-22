package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.WContact;
import com.practice.input.ContactForm;

@Service
@Transactional
public interface ContactMapperService {

	MUser findMUser(String userId);
	
	List<WContact> findContactList(String userId);
	
		
	List<MDictionary> findContactTypeList();
	
	List<MDictionary> findHowToContactList();
	
	void insertTContact(ContactForm form, String userId);
	


}
