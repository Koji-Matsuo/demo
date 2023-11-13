package com.practice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.TContact;
import com.practice.entity.WContact;
import com.practice.input.ContactForm;
import com.practice.mapper.ContactMapper;
import com.practice.service.ContactMapperService;

@Service
@Transactional
public class ContactMapperServiceImpl implements ContactMapperService{

	private final ContactMapper mapper;
	//コンストラクタインジェクション
	ContactMapperServiceImpl(ContactMapper mapper){
		this.mapper = mapper;
	}


    /**
     * ユーザー情報を取得する。
     * @return ユーザー情報
     */
	@Override
	public MUser findMUser(String userId){
    	return mapper.findMUser(userId); 
    }
    
	
	public List<WContact> findContactList(String userId) {
		return mapper.findContactList(userId);
	}
	
	
	public List<MDictionary> findContactTypeList() {
		return mapper.findContactTypeList();
	}
	
	public List<MDictionary> findHowToContactList(){
		return mapper.findHowToContactList();
	}
	public void insertTContact(ContactForm form, String userId) {
		TContact tcontact = new TContact();
		MUser user = findMUser(userId);
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
