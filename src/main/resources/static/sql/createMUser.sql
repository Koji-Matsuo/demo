create table m_user 
(
 user_id varchar(8) not null , 
 user_name varchar(100) not null,
 mail_address varchar(500) not null,
 phone_number varchar(15),
 primary key (user_id)
);
alter table m_user add 
(
role_code varchar(20) 
);
alter table m_user add 
(
password varchar(200) 
);
alter table m_user
add
(
ride_user varchar(8)
);
