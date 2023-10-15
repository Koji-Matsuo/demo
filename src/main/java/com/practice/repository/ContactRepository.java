package com.practice.repository;

import java.util.List;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.TContact;
import com.practice.input.ContactForm;

public interface ContactRepository {
	
    /**
     * 一覧を取得する。
     */
    List<TContact> findContactList(String userId);
	/**
     * ユーザー情報を取得する。
     */
    MUser findMUser(String userId);
    
    /**
     *　お問い合わせ種別を取得する。
     */
    List<MDictionary> findContactTypeList();

    /**
     *　ご希望の連絡方法を取得する。
     */
    List<MDictionary> findHowToContactList();

    /**
     * データベースにデータを登録する
     */
    void insertTContact(ContactForm contactForm);
    
}
