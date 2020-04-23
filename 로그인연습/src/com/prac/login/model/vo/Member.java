package com.prac.login.model.vo;

public class Member {

	private int mNo;
	private String mId;
	private String mPwd;
	private String mGender;

	public Member() {
	}

	public Member(int mNo, String mId, String mPwd, String mGender) {
		this.mNo = mNo;
		this.mId = mId;
		this.mPwd = mPwd;
		this.mGender = mGender;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
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

	public String getmGender() {
		return mGender;
	}

	public void setmGender(String mGender) {
		this.mGender = mGender;
	}

	@Override
	public String toString() {
		return "Member [mNo=" + mNo + ", mId=" + mId + ", mPwd=" + mPwd + ", mGender=" + mGender + "]";
	}

}
