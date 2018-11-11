
-- Teacher
INSERT into TEACHER (TEACHER_CODE, FIRST_NAME, MIDDLE_NAME, LAST_NAME) --ID,
values ('tc01', 'Hải','Thanh','Phan');--1,

-- Course
INSERT into COURSE (ID, COURSE_CODE, COURSE_NAME) 
values (1, 'mat-01', 'Toan roi rac');

INSERT into COURSE (ID, COURSE_CODE, COURSE_NAME) 
values (2, 'mat-02', 'Toan cao cap');

INSERT into COURSE (ID, COURSE_CODE, COURSE_NAME) 
values (3, 'mat-03', 'Toan tuyen tinh');

-- Training class
INSERT into TRAINING_CLASS (ID, CLASS_CODE, CLASS_NAME, REF_TEACHER_CODE, REF_COURSE_CODE
, FROM_DATE, TO_DATE) 
values (1, 'class01', 'MAT', 'tc01', 'mat-02' , {ts '2018-10-25'},{ts '2019-05-25'});

-- Student
INSERT into STUDENT (ID, STUDENT_CODE, FIRST_NAME, MIDDLE_NAME, LAST_NAME, REF_CLASS_CODE) 
values (1,'st01', 'NAM', 'HOANG', 'LE', 'class01');

INSERT into STUDENT (ID, STUDENT_CODE, FIRST_NAME, MIDDLE_NAME, LAST_NAME, REF_CLASS_CODE) 
values (2, 'st02', 'Vân','Thế','Lý', 'class01');

INSERT into STUDENT (ID, STUDENT_CODE, FIRST_NAME, MIDDLE_NAME, LAST_NAME, REF_CLASS_CODE) 
values (3, 'st03', 'Tốn','Văn','Tạ', 'class01');

INSERT into STUDENT (ID, STUDENT_CODE, FIRST_NAME, MIDDLE_NAME, LAST_NAME, REF_CLASS_CODE) 
values (4, 'st04', 'Kị','Vô','Trương', 'class01');

INSERT into STUDENT (ID, STUDENT_CODE, FIRST_NAME, MIDDLE_NAME, LAST_NAME, REF_CLASS_CODE) 
values (5, 'st05', 'Vương','Minh','Hoàng', 'class01');

