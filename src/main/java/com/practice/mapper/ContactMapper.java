package com.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.TContact;
import com.practice.entity.WContact;

@Mapper
public interface ContactMapper {
	

    /**
     * 一覧を取得する。
     */
    List<WContact> findContactList(String userId);

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
    void insertTContact(TContact tcontact);

}
