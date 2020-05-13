--BM�ε���
--�α⵵��
select * from(
select c_info, b_title, b_author, b_rent_cnt, b_rent_yn, b_isbn 
from tb_book  
inner join tb_code
on b_category = c_code 
order by b_rent_cnt desc 
) where rownum < 5;

--���׵𼿷�
select * from(
select * from(
select c_info, b_title, b_author, b_rent_cnt, b_rent_yn, b_regdate, b_isbn 
from tb_book  
inner join tb_code
on b_category = c_code 
order by b_rent_cnt desc
) where rownum < 31
order by b_regdate desc)
where rownum < 5;

--�ֱٴ��⵵��
select * from(
select c_info, b_title, b_author, b_rent_cnt, b_rent_yn, b_isbn 
from tb_book b  
inner join tb_rent_book rb using(b_bno)
inner join tb_code on b_category = c_code 
order by rb_regdate desc
)
where rownum < 5;

--�ֱ��԰���
select * from(
select c_info, b_title, b_author, b_rent_cnt, b_rent_yn, b_isbn 
from tb_book  
inner join tb_code
on b_category = c_code 
order by b_regdate desc 
) where rownum < 5;

-------------------------------------------------------------

--member
--�α���
select 
m.m_id,m_email,c_info,m_tell,m_reg_date,m_rentable_date
from 
tb_member m
inner join tb_code c on
m_grade = c_code
where 
m_id = 'aaa' 
and m_password = '1256812gk!';

-------------------------------------------------------------

--mypage
--���� �� ����
select * from tb_rent_master 
where m_id = 'aaa'

--����� �󼼺���
select 
rm_idx, 
rb.rb_idx, 
rb.RB_REGDATE, 
rb.RB_STATE, 
rb.RB_RETURN_DATE, 
b.B_TITLE
b_bno
from tb_rent_master rm
inner join tb_rent_book rb using(rm_idx)
inner join tb_book b using(b_bno)
where m_id = 'aaa'



-------------------------------------------------------------

--book
--����Ű����˻�
select c_info, b_title, b_bno,  b_author, b_rent_cnt, b_rent_yn, b_isbn 
from tb_book  
inner join tb_code
on b_category = c_code 
where b_title like '%����%';

--�����󼼰˻�
select c_info, b_title, b_bno, b_author, b_rent_cnt, b_rent_yn, b_isbn 
from tb_book  
inner join tb_code
on b_category = c_code 
where b_isbn=9788972756194;

-------------------------------------------------------------

--use
--��������
exec INSERT_RENT_INFO()

--�����ݳ�
select * from(
	select rownum rnum, r1.* from(
		select * from 
		tb_rent_master rm
		inner join tb_rent_book rb using(rm_idx)
		inner join tb_book using(b_bno)
		order by rm_idx desc 
	)r1
	where m_id = 'aaa'
)
where rnum between 6 and 10;



-------------------------------------------------------------

--notice
--�������� �Խ���
select * from(
	select rownum rnum, n1.* from(
		select * from 
		tb_notice
		order by noticeno desc
	)n1
)
where rnum between 6 and 10;

select * from tb_member;



