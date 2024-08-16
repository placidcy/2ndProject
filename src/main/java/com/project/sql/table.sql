create sequence seq_career_career_id
    start with 1
    increment by 1
    maxValue 999
    nocycle;

create sequence seq_post_post_id
    start with 1
    increment by 1
    maxvalue 999999
    nocycle;
    
create sequence seq_reply_reply_id
    start with 1
    increment by 1
    maxvalue 999
    nocycle;


create table userinfo(
 user_id varchar2(100) constraint user_user_id_pk primary key
, name varchar2(100) constraint user_name_uq unique
, nickname varchar2(100) constraint user_nickname_uq unique
, email varchar2(100) constraint user_email_uq unique
, password varchar2(100) constraint user_password_nn not null
, created_date date default sysdate
, constraint userinfo_name_uq unique (name)
, constraint userinfo_nickname_uq unique (nickname)
, constraint userinfo_email_uq unique (email)
);

create table career (
 career_id number(3) constraint career_career_id_pk primary key
, user_id varchar2(100) constraint career_user_id_fk references userinfo (user_id)
, company_name varchar2(100)
, position varchar2(40) constraint career_position_check check (position in ('웹', '서버', '게임', '데이터', '보안'))
, joined_date date constraint career_joined_date_nn not null
, retired_date date
, is_employed char(1) constraint career_is_employed_nn not null check ( is_employed in (1, 0) )
);

create table post (
 post_id number(6) constraint post_post_id_pk primary key
, title varchar2(100) constraint post_title_nn not null
, content varchar2(4000) constraint post_content_nn not null
, tags varchar2(100)
, created_date date default sysdate
, view_count number(6) default 0 constraint post_view_count_nn not null
, user_id varchar2(100) constraint post_user_id_fk references userinfo (user_id)
, position varchar2(40) check ( position in ('웹', '서버', '게임', '데이터', '보안') )
);

create table reply (
 reply_id number(3) constraint reply_reply_id_pk primary key
, user_id varchar2(100) constraint reply_user_id_fk references userinfo(user_id)
, post_id number constraint reply_post_id_fk references post(post_id)
, content varchar2(500) constraint reply_content_nn not null
, created_at date default sysdate
, likes number default 0
);