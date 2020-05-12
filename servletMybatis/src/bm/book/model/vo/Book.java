package bm.book.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable{
	
	private static final long serialVersionUID = -8467771359424939056L;

	/*B_BNO	NUMBER
	B_CATEGORY	NUMBER(4,0)
	B_TITLE	VARCHAR2(100 CHAR)
	B_AUTHOR	VARCHAR2(100 CHAR)
	B_REGDATE	DATE
	B_RENT_YN	CHAR(1 CHAR)
	B_RENT_CNT	NUMBER(6,0)
	B_ISBN	VARCHAR2(50 BYTE)*/
	
	private int bBno;
	private int bCategory;
	private String bTitle;
	private String bAuthor;
	private Date bRegDate;
	private String bRentYN;
	private int bRentCnt;
	private String bIsbn;
	
	public Book() {
		
	}

	public Book(int bBno, int bCategory, String bTitle, String bAuthor, Date bRegDate, String bRentYN, int bRentCnt,
			String bIsbn) {
		super();
		this.bBno = bBno;
		this.bCategory = bCategory;
		this.bTitle = bTitle;
		this.bAuthor = bAuthor;
		this.bRegDate = bRegDate;
		this.bRentYN = bRentYN;
		this.bRentCnt = bRentCnt;
		this.bIsbn = bIsbn;
	}

	public int getbBno() {
		return bBno;
	}

	public void setbBno(int bBno) {
		this.bBno = bBno;
	}

	public int getbCategory() {
		return bCategory;
	}

	public void setbCategory(int bCategory) {
		this.bCategory = bCategory;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public Date getbRegDate() {
		return bRegDate;
	}

	public void setbRegDate(Date bRegDate) {
		this.bRegDate = bRegDate;
	}

	public String getbRentYN() {
		return bRentYN;
	}

	public void setbRentYN(String bRentYN) {
		this.bRentYN = bRentYN;
	}

	public int getbRentCnt() {
		return bRentCnt;
	}

	public void setbRentCnt(int bRentCnt) {
		this.bRentCnt = bRentCnt;
	}

	public String getbIsbn() {
		return bIsbn;
	}

	public void setbIsbn(String bIsbn) {
		this.bIsbn = bIsbn;
	}

	@Override
	public String toString() {
		return "Book [bBno=" + bBno + ", bCategory=" + bCategory + ", bTitle=" + bTitle + ", bAuthor=" + bAuthor
				+ ", bRegDate=" + bRegDate + ", bRentYN=" + bRentYN + ", bRentCnt=" + bRentCnt + ", bIsbn=" + bIsbn
				+ "]";
	}

}
