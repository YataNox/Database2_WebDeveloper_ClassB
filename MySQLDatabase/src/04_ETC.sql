-- command 창에서 운영되는 mysql 프로그램 접속

-- mysql -h localhost -u root -p
-- -h : host, -u : user, -p : password

-- mysql 종료는 quit또는 exit

-- Schema 생성
create schema scott default chracter set utf8mb4;

-- 사용하려는 스키마로 이동
use scott;

-- 현재 스키마의 테이블들 보기
show tables;

-- 테이블의 구조 복
desc 테이블이름;


-- mysql의 외래키
-- foreign key(필드명) references 스키마이름.테이블이름(필드명);
-- 추가 옵션 : on delete cascade, on update cascade
-- 참조되는 테이블의 로우가 지워지고 수정될 때 참조하는 테이블의 연관된 로우들도 같이 지워지고 수정됨
-- 참조 값들과 참조되는 값들의 데이터를 일치시키기 위해 사용하는 옵션

-- LIMIT
-- select로 데이터 조회할 대 조회할 레코드의 갯수를 조절 제한 할 수 있습니다.
select * from memberlist order by membernum desc limit 5;
-- 회원 정보 조회하여 5개의 레코드만 출력

-- OFFSET
-- select로 데이터 조회할 때, 맨 위에서부터 offset에 지정한 번째까지는 뛰어 넘고 그 다음부터 리턴
select * from memberlist order by membernum desc limit 10 offset 5;
-- 6번째 데이터부터 10개 레코드 리턴. 개수가 모자르면 있는 곳까지 리턴

-- limit 와 offset의 동시 사용
select * from memberlist order by membernum desc limit 5 offset 5;
-- 6번째 데이터부터 5개의 레코드 리턴

-- offset과 limit는 게시판이나, 상품 진열시에 페이지를 표시하기 위한 용도로 가장 많이 사용합니다.

