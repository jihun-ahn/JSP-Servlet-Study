CREATE TABLE student_tbl(
    id VARCHAR2(30),
    name VARCHAR2(30),
    pwd VARCHAR2(30),
    s_class CHAR(1)
);

CREATE TABLE teacher_tbl(
    id VARCHAR2(30),
    name VARCHAR2(30),
    pwd VARCHAR2(30),
    t_class CHAR(1)
);

CREATE TABLE subject_tbl(
    id VARCHAR2(30),
    name VARCHAR2(30)
);

CREATE TABLE score_tbl(
    name VARCHAR2(30),
    kor NUMBER(3),
    eng NUMBER(3),
    math NUMBER(3),
    sci NUMBER(3),
    soc NUMBER(3)
);

INSERT INTO student_tbl
VALUES('Kim', '김길동', '1234', 'A');
INSERT INTO student_tbl
VALUES('Na', '나길순', '1234', 'A');
INSERT INTO student_tbl
VALUES('Do', '도길동', '1234', 'A');
INSERT INTO student_tbl
VALUES('Ryu', '류길순', '1234', 'A');
INSERT INTO student_tbl
VALUES('Moon', '문길동', '1234', 'A');
INSERT INTO student_tbl
VALUES('Bae', '배길순', '1234', 'B');
INSERT INTO student_tbl
VALUES('Sung', '성길동', '1234', 'B');
INSERT INTO student_tbl
VALUES('Lee', '이길자', '1234', 'B');
INSERT INTO student_tbl
VALUES('Jang', '장길석', '1234', 'B');
INSERT INTO student_tbl
VALUES('Chun', '천길희', '1234', 'B');

INSERT INTO teacher_tbl
VALUES('Hong', '홍길동', '1234', 'A');
INSERT INTO teacher_tbl
VALUES('Pi', '피길자', '1234', 'B');

INSERT INTO subject_tbl
VALUES('Kor', '국어');
INSERT INTO subject_tbl
VALUES('Eng', '영어');
INSERT INTO subject_tbl
VALUES('Math', '수학');
INSERT INTO subject_tbl
VALUES('Sci', '과학');
INSERT INTO subject_tbl
VALUES('Soc', '사회');

INSERT INTO score_tbl
VALUES('김길동', 75, 80, 64, 77, 70);
INSERT INTO score_tbl
VALUES('나길순', 95, 69, 68, 71, 97);
INSERT INTO score_tbl
VALUES('도길동', 85, 54, 83, 69, 75);
INSERT INTO score_tbl
VALUES('류길순', 96, 94, 58, 90, 98);
INSERT INTO score_tbl
VALUES('문길동', 98, 78, 87, 92, 96);
INSERT INTO score_tbl
VALUES('배길순', 85, 65, 56, 53, 68);
INSERT INTO score_tbl
VALUES('성길동', 91, 91, 82, 79, 74);
INSERT INTO score_tbl
VALUES('이길자', 81, 94, 62, 89, 70);
INSERT INTO score_tbl
VALUES('장길석', 50, 77, 57, 87, 96);
INSERT INTO score_tbl
VALUES('천길희', 55, 52, 81, 85, 90);

SELECT * FROM student_tbl;

SELECT * FROM teacher_tbl;

SELECT * FROM subject_tbl;

SELECT * FROM score_tbl;

COMMIT;