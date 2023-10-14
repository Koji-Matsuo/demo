create table m_dictionary
(
dic_page int(5) not null,
dic_section int(5) not null,
dic_title1 varchar(100) not null, 
dic_title2 varchar(100),
dic_title_3 varchar(100),
dic_content1 varchar(2000),
dic_content2 varchar(2000),
dic_content3 varchar(2000),
dic_int1 int(10),
dic_int2 int(10),
dic_int3 int(10),
dic_flag1 int(1) default 0,
dic_flag2 int(1) default 0,
dic_flag3 int(1) default 0,
dic_type1 int(2) default 0,
dic_type2 int(2) default 0,
dic_type3 int(2) default 0,
dic_date1 timestamp,
dic_date2 timestamp,
dic_date3 timestamp,
primary key(dic_page,dic_section)
)