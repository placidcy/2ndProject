INSERT INTO career (career_id, user_id, company_name, position, joined_date, retired_date, is_employed)
VALUES (seq_career_career_id.NEXTVAL, 'USER001', '테크 이노베이터스', '웹', TO_DATE('2018-03-01', 'YYYY-MM-DD'), NULL, '1');

INSERT INTO career (career_id, user_id, company_name, position, joined_date, retired_date, is_employed)
VALUES (seq_career_career_id.NEXTVAL, 'USER001', '크리에이티브 솔루션즈', '웹', TO_DATE('2015-06-15', 'YYYY-MM-DD'), TO_DATE('2018-02-28', 'YYYY-MM-DD'), '0');

INSERT INTO career (career_id, user_id, company_name, position, joined_date, retired_date, is_employed)
VALUES (seq_career_career_id.NEXTVAL, 'USER002', '보안 시스템즈', '보안', TO_DATE('2017-07-15', 'YYYY-MM-DD'), TO_DATE('2022-11-01', 'YYYY-MM-DD'), '0');

INSERT INTO career (career_id, user_id, company_name, position, joined_date, retired_date, is_employed)
VALUES (seq_career_career_id.NEXTVAL, 'USER003', '게임 마스터즈', '게임', TO_DATE('2019-10-10', 'YYYY-MM-DD'), NULL, '1');

commit;