1. 자바스크립트로 직무선택 체크 여부 검사
2. 자바스크립트로 직무, 제목, 내용, 태그 입력양식 검사
3. 입력 값 DB 저장
user_id: 요청과 함께 게시글 작성 페이지에서 넘어온 쿠키 값
position: 요청과 함께 게시글 작성 페이지에서 넘어온 직무 값
title: 요청과 함께 게시글 작성 페이지에서 넘어온 제목 값
content: 요청과 함께 게시글 작성 페이지에서 넘어온 내용 값
tags: 요청과 함께 게시글 작성 페이지에서 넘어온 태그 값

insert into post (post_id, title, content, tags, user_id, position) values (seq_post_post_id.nextval, title, content, tags, user_id, position);

테스트 쿼리
insert into post (post_id, title, content, tags, user_id, position) values (seq_post_post_id.nextval, '첫 면접 경험 공유', '저의 첫 면접 경험이 생각보다 긴장되고 힘들었는데, 여러분도 그런 경험이 있으신가요?
        면접 때 떨지 않고 잘 답변하는 방법이 있으면 알려주세요!', '#첫면접,#경험공유', 'USER001', '웹');