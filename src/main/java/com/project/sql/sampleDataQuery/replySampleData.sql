
BEGIN
    FOR i IN 1..45 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                1,
                '정말 유익한 정보네요! 감사합니다.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..12 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                2,
                '이 글 덕분에 보안의 중요성을 알게 되었습니다.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..32 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                5,
                '데이터 분석에 대해 더 알고 싶습니다. 좋은 글 감사합니다.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..26 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                8,
                '게임 개발에 관심이 많은데 좋은 정보네요.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..17 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                9,
                '서버 보안이 얼마나 중요한지 알게 되었습니다.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..50 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                11,
                'React에 대한 좋은 정보 감사해요!');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..38 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                13,
                '게임 그래픽 디자인에 대해 더 알고 싶어요.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..24 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                14,
                '서버 관리에 대해 배울 수 있어 좋았습니다.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..8 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                17,
                '네트워크 보안에 대해 더 알고 싶네요.');
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..40 LOOP
        INSERT INTO reply (reply_id, user_id, post_id, content)
        VALUES (seq_reply_reply_id.NEXTVAL, 
                (SELECT user_id FROM (SELECT * FROM userinfo ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1),
                19,
                '서버 확장성에 대한 유익한 정보 감사합니다.');
    END LOOP;
END;
/

commit;
