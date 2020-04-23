package com.kh.jspPrac.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 5371132335787839155L;
	private String mId;
	private String mPwd;
	private int mGrade;
	private String phone;
	private Date rentAble_Date;

	public Member() {
	}

	public Member(String mId, String mPwd, int mGrade, String phone, Date rentAble_Date) {
		this.mId = mId;
		this.mPwd = mPwd;
		this.mGrade = mGrade;
		this.phone = phone;
		this.rentAble_Date = rentAble_Date;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPwd() {
		return mPwd;
	}

	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public int getmGrade() {
		return mGrade;
	}

	public void setmGrade(int mGrade) {
		this.mGrade = mGrade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRentAble_Date() {
		return rentAble_Date;
	}

	public void setRentAble_Date(Date rentAble_Date) {
		this.rentAble_Date = rentAble_Date;
	}

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPwd=" + mPwd + ", mGrade=" + mGrade + ", phone=" + phone + ", rentAble_Date="
				+ rentAble_Date + "]";
	}

}
