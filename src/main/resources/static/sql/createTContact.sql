create table t_contact 
(
contact_id int(10) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id  varchar(8) not null, 
user_name varchar(100) not null,
mail_address varchar(500) not null, 
contact_type int(1) default 0 ,
phone_number varchar(15) , 
howto_contact int(1) default 0 ,
contact_message varchar(2000) ,
admin_recovery varchar(2000),
contact_date date
);
create table t_contact_sequence 
(
contact_id int not null
);
create index index_t_contact_user_id on t_contact (user_id);
create index index_t_contact_mail_address on t_contact (mail_address);
