package bm.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 937629766149314115L;
	private String m_id;
	private String m_password;
	private String m_email;
	private String m_Grade;
	private String m_tell;
	private Date m_reg_date;
	private Date m_rentable_date;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, String m_password, String m_email, String m_Grade, String m_tell, Date m_reg_date,
			Date m_rentable_date) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_email = m_email;
		this.m_Grade = m_Grade;
		this.m_tell = m_tell;
		this.m_reg_date = m_reg_date;
		this.m_rentable_date = m_rentable_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_Grade() {
		return m_Grade;
	}

	public void setM_Grade(String m_Grade) {
		this.m_Grade = m_Grade;
	}

	public String getM_tell() {
		return m_tell;
	}

	public void setM_tell(String m_tell) {
		this.m_tell = m_tell;
	}

	public Date getM_reg_date() {
		return m_reg_date;
	}

	public void setM_reg_date(Date m_reg_date) {
		this.m_reg_date = m_reg_date;
	}

	public Date getM_rentable_date() {
		return m_rentable_date;
	}

	public void setM_rentable_date(Date m_rentable_date) {
		this.m_rentable_date = m_rentable_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_password=" + m_password + ", m_email=" + m_email + ", m_Grade=" + m_Grade
				+ ", m_tell=" + m_tell + ", m_reg_date=" + m_reg_date + ", m_rentable_date=" + m_rentable_date + "]";
	}

}