CREATE TABLE board(
    num NUMBER(5) PRIMARY KEY,
    pass VARCHAR2(30),
    name VARCHAR2(30),
    email VARCHAR2(30),
    title VARCHAR2(50),
    content VARCHAR2(1000),
    readcount NUMBER(4) DEFAULT 0,
    writedate DATE DEFAULT sysdate
);

CREATE SEQUENCE board_seq
NOCACHE;

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '홍길동', 'hong@naver.com', '1234', '첫 방문', '왔다 갑니다');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '김길동', 'kim@naver.com', '1234', '반가워요', '대출은 000-0000-0000');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '고길동', 'ko@naver.com', '1234', '안녕하세요', '건강하시죠');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '홍길동', 'hong@naver.com', '1234', '두 번째 방문', '이제 이것은 제겁니다.');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '박길동', 'park@naver.com', '1234', '밥은 먹었냐?', '친구야 밥먹으러 가자');

COMMIT;

SELECT * FROM board;

DELETE FROM board WHERE num=7;
