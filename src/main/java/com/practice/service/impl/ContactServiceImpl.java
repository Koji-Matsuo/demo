package com.practice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.TContact;
import com.practice.input.ContactForm;
import com.practice.repository.ContactRepository;
import com.practice.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{
	
	private final ContactRepository repository;

	//コンストラクタインジェクション
	ContactServiceImpl(ContactRepository repository){
		this.repository = repository;
	}
	
    /**
     * 一覧を取得する。
     * @return t_contact データ一覧。
     */
	
	@Override
	public List<TContact> findContactList(String userId){
    	return repository.findContactList(userId);
    }
    
    /**
     * ユーザー情報を取得する。
     * @return ユーザー情報
     */
	@Override
	public MUser findMUser(String userId){
    	return repository.findMUser(userId); 
    }
    
    /**
     *　お問い合わせ種別を取得する。
     * @return お問い合わせ種別
     */
	@Override
	public List<MDictionary> findContactTypeList(){
    	return repository.findContactTypeList();
    }
    
	/**
     *　お問い合わせ種別を取得する。
     * @return お問い合わせ種別
     */
	@Override
	public List<MDictionary> findHowToContactList(){
    	return repository.findHowToContactList();
    }
    
    
    /**
     * データベースにデータを登録する
     */
	@Override
	public void insertTContact(ContactForm contactForm, String userId) {    	
		repository.insertTContact(contactForm, userId);
    }
    
}
