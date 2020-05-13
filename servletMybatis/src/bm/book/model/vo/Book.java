package bm.book.model.vo;

public class Book {
	
	private int b_bno;
	private String b_category;
	private String b_title;
	private String b_author;
	private String b_rent_yn;
	private int b_rent_cnt;
	private String b_isbn;
	
	public Book() {
		super();
	}
	
	

	public Book(int b_bno, String b_category, String b_title, String b_author, String b_rent_yn, int b_rent_cnt,
			String b_isbn) {
		super();
		this.b_bno = b_bno;
		this.b_category = b_category;
		this.b_title = b_title;
		this.b_author = b_author;
		this.b_rent_yn = b_rent_yn;
		this.b_rent_cnt = b_rent_cnt;
		this.b_isbn = b_isbn;
	}

	public int getB_bno() {
		return b_bno;
	}

	public void setB_bno(int b_bno) {
		this.b_bno = b_bno;
	}

	
	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public String getB_rent_yn() {
		return b_rent_yn;
	}

	public void setB_rent_yn(String b_rent_yn) {
		this.b_rent_yn = b_rent_yn;
	}

	public int getB_rent_cnt() {
		return b_rent_cnt;
	}

	public void setB_rent_cnt(int b_rent_cnt) {
		this.b_rent_cnt = b_rent_cnt;
	}

	public String getB_isbn() {
		return b_isbn;
	}

	public void setB_isbn(String b_isbn) {
		this.b_isbn = b_isbn;
	}



	@Override
	public String toString() {
		return "Book [b_bno=" + b_bno + ", b_category=" + b_category + ", b_title=" + b_title + ", b_author=" + b_author
				+ ", b_rent_yn=" + b_rent_yn + ", b_rent_cnt=" + b_rent_cnt + ", b_isbn=" + b_isbn + "]";
	}
	
	
	
	
}
