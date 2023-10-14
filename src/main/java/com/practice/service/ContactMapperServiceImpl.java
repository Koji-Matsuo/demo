package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.TContact;
import com.practice.entity.WContact;
import com.practice.form.ContactForm;
import com.practice.mapper.ContactMapper;

@Service
@Transactional
public class ContactMapperServiceImpl implements ContactMapperService{

	ContactMapperServiceImpl(){
	}
	
	@Autowired private ContactMapper mapper;

    /**
     * ユーザー情報を取得する。
     * @return ユーザー情報
     */
	@Override
	public MUser findMUser(){
    	return mapper.findMUser(); 
    }
    
	
	public List<WContact> findContactListJoin() {
		return mapper.findContactListJoin();
	}
	
	
	public List<MDictionary> findContactTypeList() {
		return mapper.findContactTypeList();
	}
	
	public List<MDictionary> findHowToContactList(){
		return mapper.findHowToContactList();
	}
	public void insertTContact(ContactForm form) {
		TContact tcontact = new TContact();
		MUser user = findMUser();
		tcontact.setUserId(user.getUserId());
		tcontact.setUserName(user.getUserName());
		tcontact.setContactMessage(form.getContactMessage());
		tcontact.setContactType(form.getContactType());
		tcontact.setPhoneNumber(user.getPhoneNumber());
		tcontact.setHowtoContact(form.getHowtoContact());
		tcontact.setMailAddress(user.getMailAddress());	
		mapper.insertTContact(tcontact);
	}


}
