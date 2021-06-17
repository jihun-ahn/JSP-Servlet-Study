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
VALUES(board_seq.nextval, 'ȫ�浿', 'hong@naver.com', '1234', 'ù �湮', '�Դ� ���ϴ�');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '��浿', 'kim@naver.com', '1234', '�ݰ�����', '������ 000-0000-0000');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '��浿', 'ko@naver.com', '1234', '�ȳ��ϼ���', '�ǰ��Ͻ���');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, 'ȫ�浿', 'hong@naver.com', '1234', '�� ��° �湮', '���� �̰��� ���̴ϴ�.');

INSERT INTO board(num, name, email, pass, title, content)
VALUES(board_seq.nextval, '�ڱ浿', 'park@naver.com', '1234', '���� �Ծ���?', 'ģ���� ������� ����');

COMMIT;

SELECT * FROM board;

DELETE FROM board WHERE num=7;
