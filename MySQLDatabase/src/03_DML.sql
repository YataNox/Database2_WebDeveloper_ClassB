-- 세 개의 테이블에 각 필드의 자료형과 제약사항에 맞게 각 10개의 레코드를 insert 해주세요.
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('좀비아이', 2020, 12000, 2500, 'all');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('a특공대', 2012, 14000, 1400, '18');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('콘스탄틴', 2010, 15000, 1500, '13');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('바람의 검심', 2000, 18000, 2500, 'all');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('날씨의 아이', 2021, 30000, 3000, '18');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('씽', 2020, 20000, 2000, 'all');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('이것이자바다', 2017, 20700, 2500, '13');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('JSP웹프로그래밍', 2016, 20000, 2500, '13');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('오라클데이터베이스', 2020, 30000, 3000, '18');

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('오버로드', 2020, 12000, 2500, 'all');
--------------------------------------------------------------------------------------------
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('박지성', '010-1111-2222', '1981/04/04', 140, 29, 'F');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('박지헌', '010-1112-2222', '1980/09/04', 150, 30, 'M');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('구자철', '010-1113-2222', '1975/12/24', 200, 35, 'M');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('김태희', '010-1114-2222', '1970/04/13', 340, 40, 'F');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('백종원', '010-1115-2222', '1965/01/11', 180, 45, 'M');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('김명민', '010-1116-2222', '1974/04/04', 100, 36, 'M');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('전지현', '010-1117-2222', '1969/06/09', 600, 41, 'F');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('박동현', '010-1118-2222', '1997/07/30', 250, 25, 'M');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('신지은', '010-1119-2222', '1993/08/24', 240, 29, 'F');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('유해진', '010-1110-2222', '1993/02/14', 360, 29, 'M');

--------------------------------------------------------------------------------------
insert into scott.rentlist(booknum, membernum, discount) values(1, 1, 100);
insert into scott.rentlist(booknum, membernum, discount) values(1, 10, 100);
insert into scott.rentlist(booknum, membernum, discount) values(2, 9, 100);
insert into scott.rentlist(booknum, membernum, discount) values(3, 8, 100);
insert into scott.rentlist(booknum, membernum, discount) values(4, 7, 100);
insert into scott.rentlist(booknum, membernum, discount) values(5, 6, 100);
insert into scott.rentlist(booknum, membernum, discount) values(6, 5, 100);
insert into scott.rentlist(booknum, membernum, discount) values(7, 4, 100);
insert into scott.rentlist(booknum, membernum, discount) values(8, 3, 100);
insert into scott.rentlist(booknum, membernum, discount) values(9, 2, 100);
