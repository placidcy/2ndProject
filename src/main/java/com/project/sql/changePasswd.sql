1. 자바스크립트로 비밀번호 변경 양식 검사
2. 서버에서 현재 비밀번호 일치 검사
user_id: 요청과 함께 비밀번호 변경 페이지에서 넘어온 쿠키 값
select * from userinfo where user_id = user_id;
3. 비밀번호 변경
user_id: 요청과 함께 비밀번호 변경 페이지에서 넘어온 쿠키 값
newPasswd: 요청과 함께 비밀번호 변경 페이지에서 넘어온 값
update userinfo set password = newPasswd where user_id = user_id;


테스트 쿼리
select * from userinfo where user_id = 'USER001';

update userinfo set password = 'securePass!45' where user_id = 'USER001';
select * from userinfo where user_id = 'USER001';
securePass!23 => securePass!45 변경 확인