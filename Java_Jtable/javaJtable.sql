CREATE TABLE lectures (
    id NUMBER PRIMARY KEY, -- 고유 ID
    professor_name VARCHAR2(50), -- 교수 이름
    lecture_name VARCHAR2(100), -- 강의명
    lecture_time VARCHAR2(50) -- 강의 시간
);

-- 샘플 데이터 삽입
INSERT INTO lectures VALUES (1, '김주현', '자바 프로그래밍', 'Monday 9:00 AM');
INSERT INTO lectures VALUES (2, '허봉식', '프론트엔드 프로그래밍', 'Tuesday 10:00 AM');
INSERT INTO lectures VALUES (3, '허봉식', '라이프 가이드', 'Tuesday 1:00 PM');
INSERT INTO lectures VALUES (4, '김진숙', '항만물류 사물인터넷 실습', 'Tuesday 2:00 PM');
INSERT INTO lectures VALUES (5, '김경민', '데이터 베이스', 'Thursday 10:00 AM');
INSERT INTO lectures VALUES (6, '허봉식', '프론트엔드 프로그래밍', 'Friday 10:00 AM');
INSERT INTO lectures VALUES (7, '김경민', '데이터 베이스', 'Friday 1:00 PM');

COMMIT;

GRANT SELECT ON lectures TO system;


SELECT table_name FROM all_tables WHERE table_name = 'LECTURES';


SELECT * FROM lectures;

DESC lectures;

