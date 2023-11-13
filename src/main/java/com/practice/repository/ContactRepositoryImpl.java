package com.practice.repository;

import java.util.List;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.entity.MDictionary;
import com.practice.entity.MUser;
import com.practice.entity.TContact;
import com.practice.input.ContactForm;

@Repository
public class ContactRepositoryImpl implements ContactRepository{	
      
	private final JdbcTemplate jdbcTemplate;
	//コンストラクタインジェクション
	public ContactRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /**
     * 一覧を取得する。
     * @return t_contact データ一覧。
     */
    @Override
    public List<TContact> findContactList(String userId){
        return jdbcTemplate.query("select * from t_contact where user_id=? order by contact_id desc", new DataClassRowMapper<>(TContact.class), userId);
    }
    
    /**
     * ユーザー情報を取得する。
     * @return ユーザー情報
     */
    @Override
    public MUser findMUser(String userId){
    	return jdbcTemplate.queryForObject("select * from m_user where user_id=?", new DataClassRowMapper<>(MUser.class), userId);
    }

    
    
    /**
     *　お問い合わせ種別を取得する。
     * @return お問い合わせ種別
     */
    @Override
    public List<MDictionary> findContactTypeList(){
    	return jdbcTemplate.query("select * from m_dictionary where dic_page=1 ", new DataClassRowMapper<>(MDictionary.class));
    }

    /**
     *　ご希望のれ連絡方法を取得する。
     * @return ご希望の連絡方法
     */
    @Override
    public List<MDictionary> findHowToContactList(){
    	return jdbcTemplate.query("select * from m_dictionary where dic_page=2 ", new DataClassRowMapper<>(MDictionary.class));
    }

    
    /**
     * データベースにデータを登録する
     */
    @Override
    public void insertTContact(ContactForm contactForm,String userId) {
        // 画面の入力値を設定する
    	TContact contact = getTContact(contactForm);   	
    	// ユーザー情報を設定する
    	MUser user = findMUser(userId);
    	contact.setMailAddress(user.getMailAddress());
    	contact.setPhoneNumber(user.getPhoneNumber());
    	contact.setUserId(user.getUserId());
    	contact.setUserName(user.getUserName());
        // データベースに登録する
    	String query =
    			"insert into t_contact "
    			+ "( user_id, user_name, mail_address, contact_type, phone_number, howto_contact,contact_message,contact_date)"
    			+ "values(?,?,?,?,?,?,?,now())";
    	jdbcTemplate.update(query,
    			contact.getUserId(),contact.getUserName(),contact.getMailAddress(),contact.getContactType(),contact.getPhoneNumber()
    			,contact.getHowtoContact(),contact.getContactMessage());
    }
    
    /**
     *  画面から受け取った値を設定する。
     * @param contactForm
     * @return t_contact テーブルクラス
     */
    private TContact getTContact(ContactForm contactForm) {
    	TContact contact = new TContact();
    	contact.setContactMessage(contactForm.getContactMessage());
    	contact.setContactType(contactForm.getContactType());
    	contact.setHowtoContact(contactForm.getHowtoContact());
    	return contact;
    }

}
