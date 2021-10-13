CREATE TABLE `scott`.`booklist` (
  `booknum` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  `makeyear` INT NULL,
  `inprice` INT NOT NULL,
  `rentprice` INT NOT NULL,
  `grade` VARCHAR(5) NULL DEFAULT 'all',
  PRIMARY KEY (`booknum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '도서 목록';

select * from scott.booklist;

-- AUTO_INCREMENT : 오라클의 sequence를 대신하는 자동 숫자 증가 옵션
-- VARCHAR2는 없고, VARCHAR가 가변 길이 문자를 나타냅니다.
-- CONSTRAINT없이 제약 사항을 표시합ㄴ디ㅏ.
-- 테이블 이름 앞에 스키마이름.을 반드시 붙여서 사용합니다.

-- 자주 쓰는 자료형
-- INT : 정수 자료형 (FLOAT, DOUBLE은 실수)
-- VARCHAR : 문자열 자료형, 가변 길이(CHAR는 고정 길이)
-- TEXT : 긴 문자열은 TEXT로 별도 저장
-- DATETIME : 날짜 자료형 저장
-- TINYINT : -128에서 127까지 저장하지만 여기서는 1또는 0만 저장해 볼 값 표현

-- 자주 쓰는 제약조건
-- not null : 빈 값은 받지 않는다는 듰(null은 빈 값 허용)
-- auto_increment : 숫자 자료형의 경우 다음 row가 저장될 때 자동으로 1증가
-- unsigned : 0과 양수만 허용
-- zerofill : 숫자의 자리수가 고정된 경우 빈 자리에 0을 넣음
-- default now() : 날짜 컬럼의 기본 값을 현재 시간으로 

-- 연습 문제.
-- 아래의 필드명을 담은 memberlist 테이블을 생성하세요
-- 필드명 : membernum(int, 자동 증가, 기본키), name(varchar(30), not null)
--			   Birth(date, not null), bpoint(int), joindate(date, 기본값 now()), age(int), gender(varchar(3)),
-- 테이블 comment : 회원 목록
-- 기본 문자set : utf-8mb4
-- 워크 벤치에서 테이블 생성하는 명령을 복사해오셔도 됩니다.
CREATE TABLE `scott`.`memberlist` (
  `membernum` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15),
  `birth` DATE NOT NULL,
  `bpoint` INT,
  `age` INT,
  `gender` VARCHAR(3),
  PRIMARY KEY (`membernum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '회원 목록';

ALTER TABLE `scott`.`memberlist` 
ADD COLUMN `joindate` datetime NULL DEFAULT now(),
CHANGE COLUMN `bpoint` `bpoint` INT NULL DEFAULT 0 ;


-- 연습문제2
-- 테이블 이름 : rentlist
-- 필드 : rentdate(datetime, default now()), numseq(int, AI), booknum(int),
-- 			membernum(int), discount(int)

CREATE TABLE `scott`.`rentlist` (
  `rentdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numseq` INT NOT NULL AUTO_INCREMENT,
  `booknum` INT NULL,
  `membernum` INT NULL,
  `discount` INT NULL DEFAULT 0,
  PRIMARY KEY (`numseq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '대여 목록';

-- 외래키1 : rentlist booknm은 booklist의 booknum을 참조
-- 외래키2 : rentlist membernum은 memberlist의 membernum을 참조

ALTER TABLE `scott`.`rentlist` 
ADD INDEX `booknum_idx` (`booknum` ASC) VISIBLE,
ADD INDEX `fk2_idx` (`membernum` ASC) VISIBLE;

ALTER TABLE `scott`.`rentlist` 
ADD CONSTRAINT `fk1`
  FOREIGN KEY (`booknum`)
  REFERENCES `scott`.`booklist` (`booknum`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk2`
  FOREIGN KEY (`membernum`)
  REFERENCES `scott`.`memberlist` (`membernum`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
