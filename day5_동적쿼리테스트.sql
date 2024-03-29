--전체 조회
select * from TBL_PRODUCT;
--카테고리 조회
select * from TBL_PRODUCT where category = 'B1';
--상품명 조회
select * from TBL_PRODUCT where pname like '%' || '사과' || '%';
--가격대 조회
select * from TBL_PRODUCT where price between 10000 and 40000;
-- 위의 3가지 모두 적용하기
select * from TBL_PRODUCT 
	where category='B2' and pname like '%' || '사과' || '%' and (price between 10000 and 40000);
--카테고리 출력	
select distinct category from tbl_product order by category;
--카테고리 저장 테이블
create table tbl_category(
	code char(2) primary key,
	name varchar2(20) not null
);
select * from tbl_category;


insert into tbl_category values('A1','국내과일');
insert into tbl_category values('A2','수입과일');
insert into tbl_category values('B1','인스턴트');
insert into tbl_category values('B2','선물세트');
insert into tbl_category values('C1','과자류');